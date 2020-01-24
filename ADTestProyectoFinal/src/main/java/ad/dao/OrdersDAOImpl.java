package ad.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Orders> getTFromCustomer(int id) {
		List<Orders> listOrders = (List<Orders>)em.createQuery("FROM Orders where customer_id ="+id).getResultList();
		return listOrders;
	}




	@Override
	public Orders getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Orders> getT() {
		// TODO Auto-generated method stub
		return null;
	}





	

}
