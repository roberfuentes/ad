package ad.app;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ad.Customer;
import ad.Item;
import ad.OrderLine;
import ad.Orders;
import ad.dao.CustomerDAOImpl;
import ad.dao.DAO;
import ad.dao.ItemDAOImpl;
import ad.dao.OrderLineDAOImpl;
import ad.dao.OrdersDAOImpl;
import ad.app.CustomerMethods;
public class OrderMethods {
	
	static EntityManager em;
	private final static Scanner sn = new Scanner(System.in);
	private final static CustomerMethods customer = new CustomerMethods(em);
	private final static ItemMethods item = new ItemMethods(em);
	
	public OrderMethods(EntityManager em) {
		this.em = em;
	}

	
	public static void listOrders(boolean flagContinue) {
		System.out.println("\t");
		OrdersDAOImpl daoOrder = new OrdersDAOImpl(em);
		List<Orders> orderList = daoOrder.getT();
		for(Orders order:orderList) {
			System.out.println(order.toString());
		}
		System.out.println("\t");
		if(flagContinue) {
			main.askContinue();	
		}
		
		
	}

	public static void insertOrder() throws InterruptedException {
		System.out.println("\t\t");
		//VARIABLES DAO
		OrdersDAOImpl daoOrder = new OrdersDAOImpl(em);
		CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
		OrderLineDAOImpl daoOrderLine = new OrderLineDAOImpl(em);
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		
		//VARIABLES OBJECT
		OrderLine orderline = null;
		//Variables logic
		int pickIdItem = -1;
		
		//Variables Order
		float total = 0f;
		int quantity = 0;
		
	
		System.out.println("Give the id of the customer");
		
		//Get customer id
		int id = sn.nextInt();
		System.out.println("Enter 0 when you're done");
		Customer customer = daoCustomer.getById(id);
		Orders order = new Orders(LocalDateTime.now().toString());
		order.setCustomer_id(customer);
		
		//Get Item to buy
		while(true) {
			//Listar articulos sin continuar
			//listItems(false);
			getlistItems();
			System.out.println("Give me the id of the item");
			pickIdItem = sn.nextInt();
			if(pickIdItem==0) {
				//em.clear();
				break;
			}
				
			
			Item item = daoItem.getById(pickIdItem);
			System.out.println("Item quantity?");
			quantity = sn.nextInt();
			orderline = new OrderLine(order, item, item.getPrice(), quantity, item.getPrice()*quantity);
			total += item.getPrice() * quantity;
			System.out.println(orderline.toString());
			System.out.println("Subtotal:" +total);
			em.persist(orderline);
		}
		order.setCost(total);
		
		daoOrder.insert(order);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
	
	public static void updateOrder() {
		OrdersDAOImpl daoOrders = new OrdersDAOImpl(em);
		OrderLineDAOImpl daoOrderLine = new OrderLineDAOImpl(em);
		List<OrderLine> orderLines = getListOrderLine();
		
		System.out.println("What order do you want to update?");
		listOrders(false);
		int id = sn.nextInt();
		
		Orders order = daoOrders.getById(id);
		
		System.out.println("Do you want to change the id to other order?(y/n)");
		String answer =sn.next();
		if(answer.equalsIgnoreCase("y")) {
			System.out.println("Give me the id of the order you want to change to");
			int custId = sn.nextInt();
			order.setId(custId);
			daoOrders.update(order);
		}else {
			System.out.println("DIdn't update");
		}
		
		System.out.println("Do you want to update the price?(y/n)");
		answer = sn.next();
		if(answer.equalsIgnoreCase("y")) {
			int restToOrder=0;
			while(true) {
				int tempVariable = 0;
				lineOrdersOrders(id);
				System.out.println("What orderline do you want to update?");
				int orderLineID = sn.nextInt();
				if(orderLineID == 0) {
					break;
				}
				OrderLine orderLine = daoOrderLine.getById(orderLineID);
				System.out.println("Do you want to change the quantity? (y/n)");
				answer = sn.next();
				if(answer.equalsIgnoreCase("y")) {
					System.out.println("How many do you want?");
					int quantity = sn.nextInt();
					orderLine.setQuantity(quantity);
					float cost =  quantity*orderLine.getPrice();
					orderLine.setCost(cost);
					restToOrder += cost;
					daoOrderLine.update(orderLine);
				}
			}
			
		}
		float orderCost = 0;
		for(OrderLine oLine:orderLines) {
			if(oLine.getOrder_id().getId() == id) {
				orderCost += oLine.getCost();
			}
		}
		order.setCost(orderCost);
		daoOrders.update(order);
		System.out.println("Updated order");
			
	}
	
	
	public static void lineOrdersOrders(int order_id) {
		List<OrderLine> orderLines = getListOrderLine();
		for(OrderLine orderLine:orderLines) {
			if(orderLine.getOrder_id().getId() == order_id) {
				System.out.println("\t"+orderLine.toString());
			}
		}
		
	}
	
	public static void removeOrder() {
		OrdersDAOImpl daoOrders= new OrdersDAOImpl(em);
		System.out.println("Give me the id of the order");
		listOrders(false);
		int id = sn.nextInt();
		Orders order= daoOrders.getById(id);
		System.out.println("Are you sure you want to remove the order with the next data(Y/N):\n" 
						+ order.getId() + "" + order.getOrder_date());
		String answer = sn.next();
		if(answer.equalsIgnoreCase("Y")) {
			daoOrders.remove(order);
		}else {
			main.askContinue();			
		}
		
	}
	public static void getlistItems() {
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		List<Item> itemList = daoItem.getT();
		for(Item item:itemList) {
			System.out.println(item.toString());
		}
		

	}
	//System.out.println("\t"+order.getId()+". Cost:" + order.getCost() + ", Data:" + order.getOrder_date() + ", FROM:"+order.getCustomer_id());

	
	public static List<Orders> getListOrders() {
		OrdersDAOImpl daoOrders= new OrdersDAOImpl(em);
		List<Orders> orders= daoOrders.getT();
		return orders;
	}
	

	public static List<OrderLine> getListOrderLine(){
		OrderLineDAOImpl daoOrderLine = new OrderLineDAOImpl(em);
		List<OrderLine> orderLines = daoOrderLine.getT();
		return orderLines;
	}
	
	
	
}
