package ad.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;

import com.mysql.cj.Query;

import ad.Customer;
import ad.Item;
import ad.OrderLine;
import ad.Orders;
import ad.dao.CustomerDAO;
import ad.dao.CustomerDAOImpl;
import ad.dao.DAO;
import ad.dao.ItemDAOImpl;
import ad.dao.OrderLineDAOImpl;
import ad.dao.OrdersDAOImpl;

public class main {
	
	final static Scanner sn = new Scanner(System.in);
	final static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ad.ADTestProyectoFinal");
	final static EntityManager em = entityManagerFactory.createEntityManager();
	static int code =-1;


	public static void main(String[] args) throws InterruptedException {
		
		int exitCode =-0;
		
		
		while(code != exitCode) {
			System.out.println("Choose an option");
			System.out.println("1.Customers");
			System.out.println("2.Orders");
			System.out.println("3.Order Lines");
			System.out.println("4.Items");
			System.out.println("5-Categories");
			
			code = sn.nextInt();
			
			switch(code) {
				case 1:
					subSwitchCustomer();
					break;
				case 2:
					subSwitchOrder();
					break;
			}
			
		}
 		em.close();
 		entityManagerFactory.close();
	}
	

	public static void subSwitchCustomer() throws InterruptedException {
		int subCode = -1;
		CustomerMethods customer = new CustomerMethods(em);
		System.out.println("Customer table, what do you want to do?");
		System.out.println("");
		System.out.println("1.Insert a new customer");
		System.out.println("2.Update a customer");
		System.out.println("3.Remove a customer");
		System.out.println("4.Look a list of customers");
		System.out.println("5.Look at orders of a customer");
		System.out.println("6.Look for orders that contain an item of a customer");
		System.out.println("7.Delete an order of a customer");
		
		subCode = sn.nextInt();
		switch(subCode) {
			case 1:
				customer.insertCustomer();
				break;
			case 2:
				customer.updateCustomer();
				break;
			case 3:
				customer.removeCustomer();
				break;
			case 4:
				customer.listCustomer(true);
				break;
			case 5:
				customer.ordersCustomer();
				break;
		}
		
	}
	public static void subSwitchOrder() throws InterruptedException {
		int subCode = -1;
		OrderMethods order = new OrderMethods(em);
		System.out.println("Customer table, what do you want to do?");
		System.out.println("");
		System.out.println("1.Insert a new order");
		System.out.println("2.Remove an order");
		System.out.println("3.Update an order");
		System.out.println("4.Look a list of orders");
		System.out.println("5.Look at orders of a customer");
		System.out.println("6.Look for orders that contain an item");
		subCode = sn.nextInt();
		switch(subCode) {
			case 1:
				order.insertOrder();
				break;
			case 2:
				order.removeOrder();
				break;
			case 3:
				order.updateOrder();
				break;
			case 4:
				order.listOrders();

				break;
			case 5:
				order.insertOrder();
		}
	}
	
	//ORDERLINE METHODS
	
	
	
	//ITEM METHODS
	public static void listItems(boolean flagContinue) {
		System.out.println("\t");
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		List<Item> itemList = daoItem.getT();
		for(Item item:itemList) {
			System.out.println(item.toString());
		}
		
		System.out.println("\t");
		if(flagContinue)
			askContinue();
	}
	
	public static Item getById(int id) {
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		Item item = daoItem.getById(id);
		return item;
	}
	public static void listItemsWithoutContinue() {
		System.out.println("\t");
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		List<Item> itemList = daoItem.getT();
		for(Item item:itemList) {
			System.out.println(item.toString());
		}
		
		System.out.println("\t");
	}
	
	
	
	
	
	//ORDER LINE
	public static void listOrderLine(int id) {
		System.out.println("\t");
		OrderLineDAOImpl daoOrderLine = new OrderLineDAOImpl(em);
		
		List<OrderLine> orderLineList = daoOrderLine.getTFromOrder(id);
		for(OrderLine orderLine:orderLineList) {
			System.out.println(orderLine.toString());
		}
		System.out.println("\t");
		askContinue();
		
	}
	
	
	public static void askContinue() {
		System.out.println("Do you want to continue doing operations? (y/n)");
		String ask = sn.next();

		if (ask.equalsIgnoreCase("n")) {
			code = 0;
		}	
	}
	
	
	
	
	
	
}