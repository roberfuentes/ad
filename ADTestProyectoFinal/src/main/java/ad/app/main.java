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

import ad.Category;
import ad.Customer;
import ad.Item;
import ad.OrderLine;
import ad.Orders;
import ad.dao.CategoryDAOImpl;
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
			System.out.println("2.Orders/OrderLine");
			System.out.println("3.Items");
			System.out.println("4-Categories");
			
			code = sn.nextInt();
			
			switch(code) {
				case 1:
					subSwitchCustomer();
					break;
				case 2:
					subSwitchOrder();
					break;
				case 3:
					subSwitchItem();
					break;
				case 4:
					subSwitchCategory();
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
		System.out.println("2.Update an order");
		System.out.println("3.Remove an order");
		System.out.println("4.Look a list of orders");
		System.out.println("5.Remove an orderline");
		
		subCode = sn.nextInt();
		switch(subCode) {
			case 1:
				order.insertOrder();
				break;
			case 2:
				order.updateOrder();
				break;
			case 3:
				order.removeOrder();
				break;
			case 4:
				order.listOrders(true);
				break;
			case 5:
				order.removeOrderLine();
				break;
		}
	}
	
	public static void subSwitchItem() throws InterruptedException {
		int subCode = -1;
		ItemMethods item = new ItemMethods(em);
		System.out.println("Item table, what do you want to do?");
		System.out.println("");
		System.out.println("1.Insert a new Item");
		System.out.println("2.Update an Item");
		System.out.println("3.Remove an Item");
		System.out.println("4.Look a list of Items");
		subCode = sn.nextInt();
		switch(subCode) {
			case 1:
				item.insertItem();
				break;
			case 2:
				item.updateItem();
				break;
			case 3:
				item.removeItem();
			case 4:
				item.listItems(true);
				break;
		}
	}
	
	
	public static void subSwitchCategory() throws InterruptedException {
		int subCode = -1;
		CategoryMethods category = new CategoryMethods(em);
		System.out.println("Category table, what do you want to do?");
		System.out.println("");
		System.out.println("1.Insert a new category");
		System.out.println("2.Update a category");
		System.out.println("3.Remove a category");
		System.out.println("4.Look a list of category");
		subCode = sn.nextInt();
		switch(subCode) {
			case 1:
				category.insertCategory();
				break;
			case 2:
				category.updateCategory();
				break;
			case 3:
				category.removeCategory();
				break;
			case 4:
				category.listCategory(true);
				break;
		}
	}
	
	public static void askContinue() {
		System.out.println("Do you want to continue doing operations? (y/n)");
		String ask = sn.next();

		if (ask.equalsIgnoreCase("n")) {
			code = 0;
		}	
	}
	
}
