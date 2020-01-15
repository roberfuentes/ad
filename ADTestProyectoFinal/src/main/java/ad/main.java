package ad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;

import com.mysql.cj.Query;

public class main {
	
	public static void main(String[] args) {
		
		
/*		String leave = "";
		
		while(!leave.equals("exit")) {
			
		}*/
		
		
 		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ad.ADTestProyectoFinal");

 		
 		
 		
 		
 		//Order pedido = new Order(0, "22/03/04", 50.0f, cliente);
 		
 		EntityManager em = entityManagerFactory.createEntityManager();
 		
 		em.getTransaction().begin();
 		Customer customer1 = em.find(Customer.class, 1);
 		Customer customer2 = em.find(Customer.class, 2);
 		Customer customer3 = em.find(Customer.class, 3);
 		Customer customer4 = em.find(Customer.class, 4);
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
 		Orders order1 = em.find(Orders.class, 1);
 		//Item item1 = new Item(1, "Patatas", 20.0f);
 		//Item item2 = new Item(2, "Pizza", 50.0f);
 		
 		//OrderLine orderline1 = new OrderLine(2, order1, item2, item2.getPrice(), 1, item2.getPrice()*1);
 		//order1.orderlines.add(orderline1);
 		
 		//em.persist(item2);
 		
 		//em.persist(order1);
 		//em.persist(orderline1);
 		order1.getTotal();
 		
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
	
	
	

}
