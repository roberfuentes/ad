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
import ad.dao.ItemDAOImpl;
import ad.dao.OrdersDAOImpl;
import ad.app.CustomerMethods;
public class OrderMethods {
	
	static EntityManager em;
	static Scanner sn = new Scanner(System.in);
	CustomerMethods customer = new CustomerMethods(em);
	
	public OrderMethods(EntityManager em) {
		this.em = em;
	}

	
	public static void listOrders() {
		System.out.println("\t");
		OrdersDAOImpl daoOrder = new OrdersDAOImpl(em);
		List<Orders> orderList = daoOrder.getT();
		for(Orders order:orderList) {
			System.out.println(order.toString());
		}
		System.out.println("\t");
		main.askContinue();
		
	}

	public static void insertOrder() throws InterruptedException {
		System.out.println("\t\t");
		//VARIABLES DAO
		CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
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
			main.listItems(false);
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
			System.out.println(total);
			em.persist(orderline);
		}
		order.setCost(total);
				
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		

		
		//add orderline
 		//OrderLine orderline = new OrderLine(2, order1, item2, item2.getPrice(), 1, item2.getPrice()*1);
		//askContinue();
		
	}
	
	public static void updateOrder() {
		
	}
	public static void lineOrdersOrders() {
		OrdersDAOImpl daoOrders = new OrdersDAOImpl(em);
		
		int checkUser = 0;
		
		System.out.println("Give me the id of the customer");
		int id = sn.nextInt();
		
		List<Orders> orders = daoOrders.getTFromCustomer(id);
		
		for(Orders order : orders) {
			if(checkUser==0) {
				CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
				Customer customer = daoCustomer.getById(id);
				System.out.println("The next orders are from: " + customer.getName() + " with the id = " +customer.getId() );
				System.out.println(order.toString());
				checkUser = -1;
				
			}else {
				System.out.println(order.toString());	
			}
		}
		main.askContinue();
	}
	
	public static void removeOrder() {
		OrdersDAOImpl daoOrders= new OrdersDAOImpl(em);
		System.out.println("Give me the id of the order");
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
	
}
