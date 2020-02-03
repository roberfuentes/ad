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
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update(Orders t) {
		// TODO Auto-generated method stub
		
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
		List<Orders> listOrders = (List<Orders>)em.createQuery("FROM Orders where customer_id ="+id).getResultList();
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
