package ad.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ad.Customer;
import ad.dao.CustomerDAOImpl;
import ad.dao.ItemDAOImpl;


public class CustomerTest {

	static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ad.ADTestProyectoFinal");

	static final EntityManager em = entityManagerFactory.createEntityManager();
	
	static CustomerDAOImpl daoCustomer = new CustomerDAOImpl(em);
	static ItemDAOImpl daoItem = new ItemDAOImpl(em);

	public static void main(String[] args) {

		//Customer cust = daoCustomer.getById(id);
		
		//System.out.println(cust.getName());
		
		//list all the customers
		
		
		listCustomer();
		Customer cust = findById(1);
		
		

	}
	
	public static void listCustomer() {
		List<Customer> customerList = daoCustomer.getT();
		for(Customer cust:customerList) {
			System.out.println(cust.getName());
		}
	}
	
	public static Customer findById(int id) {
		Customer customer = daoCustomer.getById(id);
		return customer;
	}
	
	//See all items


}
