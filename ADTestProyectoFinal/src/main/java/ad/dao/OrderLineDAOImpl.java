package ad.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ad.OrderLine;
import ad.Orders;

public class OrderLineDAOImpl implements OrderLineDAO{

	
	EntityManager em;
	
	
	public OrderLineDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(OrderLine t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderLine t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(OrderLine t) {
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			System.out.println("The order line has been removed from the database");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("The order line coudln't be removed");
		}
		
	}

	@Override
	public List<OrderLine> getTFromOrder(int id) {
		List<OrderLine> listOrders = (List<OrderLine>)em.createQuery("FROM OrderLine where where order="+id).getResultList();
		return listOrders;
	}

	@Override
	public OrderLine getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderLine> getT() {
		// TODO Auto-generated method stub
		return null;
	}

}
