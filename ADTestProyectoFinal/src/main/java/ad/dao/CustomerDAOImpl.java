package ad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import org.hibernate.Criteria;

import ad.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	
	EntityManager em;
	
	
	public CustomerDAOImpl(EntityManager em) {
		this.em = em;
	}
	

	@Override
	public void insert(Customer t) {
		
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();;
			System.out.println("Se ha guardado el usuario " + t.getName() +  " en la base de datos");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se ha guardado el usuario en la base de datos");
		}
	}

	@Override
	public void update(Customer t) {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			System.out.println("The customer has been updated");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("The customer couldn't be updated!");
		}
		
		
	}

	@Override
	public void remove(Customer t) {
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			System.out.println("The customer has been removed from the database");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("The customer coudln't be removed");
		}
		
		
	}

	@Override
	public List<Customer> getT() {
		
		List<Customer> custList = (List<Customer>) em.createQuery("FROM Customer").getResultList();
		return custList;
	}

	@Override
	public Customer getById(Integer id) {
		Customer customer = em.find(Customer.class, id);
		if(customer == null) {
			throw new EntityNotFoundException("Can't find Customer for ID" + id);
		}
		return customer;
	}
	
	

}
