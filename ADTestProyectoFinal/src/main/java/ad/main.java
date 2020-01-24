package ad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;

import com.mysql.cj.Query;

import ad.dao.CustomerDAO;
import ad.dao.CustomerDAOImpl;
import ad.dao.DAO;
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
		System.out.println("2.Look a list of customers");
		System.out.println("3.Look at orders of a customer");
		System.out.println("4.Look for orders that contain an item");
		System.out.println("5.Delete an order of a customer");
		System.out.println("6.Delete an item from an order");
		
		subCode = sn.nextInt();
		switch(subCode) {
			case 1:
				insertCustomer();
				break;
			case 2:
				listCustomer();
				break;
			case 3:
				ordersCustomer();
				break;
		}
		
	}
	
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
		
		
		
		
		
	}
	
	public static void askContinue() {
		System.out.println("Do you want to continue doing operations? (y/n)");
		String ask = sn.next();

		if (ask.equalsIgnoreCase("n")) {
			code = 0;
		}
		
	
	}
}
