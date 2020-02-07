package ad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import ad.OrderLine;
import ad.Orders;

public class OrderLineDAOImpl implements OrderLineDAO{

	
	EntityManager em;
	
	
	public OrderLineDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(OrderLine t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();	
	}

	@Override
	public void update(OrderLine t) {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();	
		}catch(Exception e) {
			System.out.println("The order couldn't be updated");
		}
		
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
		@SuppressWarnings("unchecked")
		List<OrderLine> listOrders = (List<OrderLine>)em.createQuery("FROM orderline where order_id="+id).getResultList();
		System.out.println(listOrders);
		return listOrders;
	}

	@Override
	public OrderLine getById(Integer id) {
		OrderLine orderLine= em.find(OrderLine.class, id);
		if(orderLine== null) {
			throw new EntityNotFoundException("Can't find Customer for ID" + id);
		}
		return orderLine;
	}

	@Override
	public List<OrderLine> getT() {
		// TODO Auto-generated method stub
		return null;
	}

}
