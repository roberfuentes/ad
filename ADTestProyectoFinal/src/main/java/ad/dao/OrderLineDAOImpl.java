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
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();;
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se ha guardado el usuario en la base de datos");
		}		
	}

	@Override
	public void update(OrderLine t) {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			System.out.println("The category has been updated");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("The category couldn't be updated!");
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
		List<OrderLine> listOrders = (List<OrderLine>)em.createQuery("FROM OrderLine where where order="+id).getResultList();
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
		List<OrderLine> listOrders = (List<OrderLine>)em.createQuery("FROM OrderLine").getResultList();
		return listOrders;
		
	}

}
