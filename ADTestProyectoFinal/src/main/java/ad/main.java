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

 		
 		Customer customer = new Customer(4, "TestCustomer2");
 		Orders order = new Orders(1, LocalDateTime.now().toString(), 20.0f, customer);

 		
 		
 		
 		//Order pedido = new Order(0, "22/03/04", 50.0f, cliente);
 		
 		EntityManager em = entityManagerFactory.createEntityManager();
 		
 		em.getTransaction().begin();
 		
 		em.persist(customer);
 		em.persist(order);
 		em.getTransaction().commit();
 		
 		
 		
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
