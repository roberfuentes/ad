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
import ad.dao.OrdersDAOImpl;

public class main {
	
	final static Scanner sn = new Scanner(System.in);
	final static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ad.ADTestProyectoFinal");
	final static EntityManager em = entityManagerFactory.createEntityManager();
	static int code =-1;


	public static void main(String[] args) throws InterruptedException {
		
		
/*		String leave = "";
		
		while(!leave.equals("exit")) {
			
		}*/
		
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
			}
			
			
		}

 		
 		
 		
 		
 		//Order pedido = new Order(0, "22/03/04", 50.0f, cliente);
 		
 		
 		/*em.getTransaction().begin();
 		Customer customer1 = em.find(Customer.class, 1);
 		Customer customer2 = em.find(Customer.class, 2);
 		Customer customer3 = em.find(Customer.class, 3);
 		Customer customer4 = em.find(Customer.class, 4);*/
 		
 		
 		//Customer customer = new Customer(4, "TestCustomer2");
 		
 		/*Orders order1 = new Orders(4, LocalDateTime.now().toString(), 24.0f, customer1);
 		Orders order2 = new Orders(5, LocalDateTime.now().toString(), 25.0f, customer2);
 		Orders order3 = new Orders(6, LocalDateTime.now().toString(), 26.0f, customer3);
 		Orders order4 = new Orders(7, LocalDateTime.now().toString(), 27.0f, customer2);*/
 		
 		
 		
 		//customer4.showPedidos();
 		
 		//em.persist(customer3);
 		/*em.persist(order1);
 		em.persist(order2);
 		em.persist(order3);
 		em.persist(order4);*/
 		
 		
 		//HERE
 		//Orders order1 = em.find(Orders.class, 1);
 		//Item item1 = new Item(1, "Patatas", 20.0f);
 		//Item item2 = new Item(2, "Pizza", 50.0f);
 		
 		//OrderLine orderline1 = new OrderLine(2, order1, item2, item2.getPrice(), 1, item2.getPrice()*1);
 		//order1.orderlines.add(orderline1);
 		
 		//em.persist(item2);
 		
 		//em.persist(order1);
 		//em.persist(orderline1);
 		//order1.getTotal();
 		
 		//em.getTransaction().commit();
 		
 		
 		
 		
 		em.close();
 		entityManagerFactory.close();

		
	}
	
	/*public static void findClients(EntityManager em) {
	       System.out.println("-- executing query --");
	       Query query = em.createQuery("SELECT * FROM clients c INNER JOIN c.id pedido");
	       List<> resultList = query.getResultList();
	       resultList.forEach(System.out::println);
	       em.close();
	}*/
	
	public static void subSwitchCustomer() throws InterruptedException {
		int subCode = -1;
		System.out.println("Customer table, what do you want to do?");
		System.out.println("");
		System.out.println("1.Insert a new customer");
		System.out.println("2.Remove a customer");
		System.out.println("3.Look a list of customers");
		System.out.println("4.Look at orders of a customer");
		System.out.println("5.Look for orders that contain an item of a customer");
		System.out.println("6.Delete an order of a customer");
		
		subCode = sn.nextInt();
		switch(subCode) {
			case 1:
				insertCustomer();
				break;
			case 2:
				removeCustomer();
				break;
			case 3:
				listCustomer();
				break;
			case 4:
				ordersCustomer();
				break;
			case 5:
				insertOrder();
		}
		
	}
	public static void subSwitchOrder() throws InterruptedException {
		int subCode = -1;
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
				insertOrder();
				break;
			case 2:
				removeOrder();
				break;
			case 3:
				updateOrder();
				break;
			case 4:
				listOrders();

				break;
			case 5:
				insertOrder();
		}
	}
	
	
	//CUSTOMER METHODS
	
	public static void listCustomer() {
		System.out.println("\t");
		CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
		List<Customer> customerList = daoCustomer.getT();
		for(Customer cust:customerList) {
			System.out.println(cust.getName());
		}
		System.out.println("\t");
		askContinue();
		
	}

	public static void insertCustomer() throws InterruptedException {
		System.out.println("\t\t");
		System.out.println("Give me a name for the new customer");
		
		String name = sn.next();
		
		CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
		Customer customer = new Customer(name);
		daoCustomer.insert(customer);
		System.out.println("Esperando a listar...");
		Thread.sleep(5000);
		listCustomer();
		System.out.println("\t");
		askContinue();
		
	}
	
	public static void ordersCustomer() {
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
		askContinue();
	}
	
	public static void removeCustomer() {
		CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
		System.out.println("Give me the id of the customer");
		int id = sn.nextInt();
		Customer customer = daoCustomer.getById(id);
		System.out.println("Are you sure you want to remove the customer with the next data(Y/N):\n"
				+ "ID:"+customer.getId()+
				"\nName:"+customer.getName()
				);
		String answer = sn.next();
		if(answer.equalsIgnoreCase("Y")) {
			daoCustomer.remove(customer);
			System.out.println("The customer has been deleted");
		}else {
			System.out.println("The customer won't be deleted");
		}
		askContinue();
	}
	
	
	
	
	
	
	
	
	//ORDERS METHODS
	public static void listOrders() {
		System.out.println("\t");
		OrdersDAOImpl daoOrder = new OrdersDAOImpl(em);
		List<Orders> orderList = daoOrder.getT();
		for(Orders order:orderList) {
			System.out.println(order.toString());
		}
		System.out.println("\t");
		askContinue();
		
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
		Orders order = new Orders(LocalDateTime.now().toString(), total, customer);
		em.persist(order);
		//Get Item to buy
		while(true) {
			listItemsWithoutContinue();
			System.out.println("Give me the id of the item");
			pickIdItem = sn.nextInt();
			if(pickIdItem==0)
				break;
			
			Item item = daoItem.getById(pickIdItem);
			System.out.println("Item quantity?");
			quantity = sn.nextInt();
			orderline = new OrderLine(order, item, item.getPrice(), quantity, item.getPrice()*1);
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
		askContinue();
	}
	
	public static void removeOrder() {
		CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
		System.out.println("Give me the id of the customer");
		int id = sn.nextInt();
		Customer customer = daoCustomer.getById(id);
		System.out.println("Are you sure you want to remove the customer with the next data(Y/N):\n"
				+ "ID:"+customer.getId()+
				"\nName:"+customer.getName()
				);
		String answer = sn.next();
		if(answer.equalsIgnoreCase("Y")) {
			daoCustomer.remove(customer);
			System.out.println("The customer has been deleted");
		}else {
			System.out.println("The customer won't be deleted");
		}
		askContinue();
	}
	
	
	
	
	
	
	
	//ORDERLINE METHODS
	
	
	
	//ITEM METHODS
	public static void listItems() {
		System.out.println("\t");
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		List<Item> itemList = daoItem.getT();
		for(Item item:itemList) {
			System.out.println(item.toString());
		}
		
		System.out.println("\t");
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
	
	
	
	
	
	
	public static void askContinue() {
		System.out.println("Do you want to continue doing operations? (y/n)");
		String ask = sn.next();

		if (ask.equalsIgnoreCase("n")) {
			code = 0;
		}	
	}
	
	
	
	
	
	
}
