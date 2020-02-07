package ad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import ad.Customer;
import ad.Orders;

public class OrdersDAOImpl implements OrdersDAO{

	
	EntityManager em;
	
	
	
	public OrdersDAOImpl(EntityManager em) {
		this.em = em;
	}



	@Override
	public void insert(Orders t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
		
	}



	@Override
	public void update(Orders t) {
		
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();	
		}catch(Exception e) {
			System.out.println("The order couldn't be updated");
		}
	}


	@Override
	public void remove(Orders t) {
		try {
			
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			System.out.println("The order has been removed from the database");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("The order coudln't be removed");
		}
		
	}


	@Override
	public List<Orders> getTFromCustomer(int id) {

		
		@SuppressWarnings("unchecked")
		List<Orders> listOrders= (List<Orders>)em.createQuery("SELECT o FROM orders o WHERE o.customer_id=6").getResultList();
		//List<Orders> listOrders = (List<Orders>)em.createQuery("SELECT o FROM orders o WHERE customer_id = :custid", Orders.class).setParameter("custid", 6).getResultList();

		return listOrders;
		
	}




	@Override
	public Orders getById(Integer id) {
		Orders order= em.find(Orders.class, id);
		if(order== null) {
			throw new EntityNotFoundException("Can't find Customer for ID" + id);
		}
		return order;
	}



	@Override
	public List<Orders> getT() {
		// TODO Auto-generated method stub
		return null;
	}





	

}
