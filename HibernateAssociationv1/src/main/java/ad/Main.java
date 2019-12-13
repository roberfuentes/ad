package ad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
 		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ad.HibernateAssociationv1");
 		
	
		Student student = new Student();
		
		student.setName("Mew");
		
		Laptop laptop = new Laptop();
		Laptop laptop2 = new Laptop();
		
		laptop.setName("HP");
		laptop2.setName("MEDION");
		
		
		student.addLaptop(laptop);
		student.addLaptop(laptop2);
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		

	}

}
