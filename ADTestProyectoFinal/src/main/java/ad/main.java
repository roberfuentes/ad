package ad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;

import com.mysql.cj.Query;

public class main {
	
	public static void main(String[] args) {
		
 		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ad.ADTestProyectoFinal");

 		
 		Customer customer = new Customer(2, "Rober");
 		//Order pedido = new Order(0, "22/03/04", 50.0f, cliente);
 		
 		EntityManager em = entityManagerFactory.createEntityManager();
 		
 		em.getTransaction().begin();
 		
 		em.persist(customer);
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
