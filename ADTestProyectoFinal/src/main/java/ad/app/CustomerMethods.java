package ad.app;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ad.Customer;
import ad.Orders;
import ad.dao.CustomerDAOImpl;
import ad.dao.OrdersDAOImpl;

public class CustomerMethods {

	static EntityManager em;
	static Scanner sn = new Scanner(System.in);
	
	public CustomerMethods(EntityManager em) {
		this.em = em;
	}

	//CUSTOMER METHODS
	
		public static void listCustomer(boolean flagContinue) {
			System.out.println("\t");
			CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
			List<Customer> customerList = daoCustomer.getT();
			for(Customer cust:customerList) {
				System.out.println(cust.getId() + ". " + cust.getName());
			}
			System.out.println("\t");
			
			if(flagContinue)
				main.askContinue();
			
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
			listCustomer(false);
			System.out.println("\t");
			main.askContinue();
			
		}
		
		public static void updateCustomer() {
			System.out.println("\t\t");
			listCustomer(false);
			CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
			System.out.println("What customer do you want to update");
			
			int id = sn.nextInt();
			
			Customer customer = daoCustomer.getById(id);
			
			System.out.println("Give me a new name");
			String name = sn.next();
			customer.setName(name);

			daoCustomer.update(customer);
			
			
			
			
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
			main.askContinue();
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
			main.askContinue();
		}
	
}
