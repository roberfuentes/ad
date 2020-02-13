package ad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import ad.Customer;
import ad.Item;

public class ItemDAOImpl implements ItemDAO{

	
	EntityManager em;
	
	public ItemDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Item t) {
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
	public void update(Item t) {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			System.out.println("The item has been updated");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("The category couldn't be updated!");
		}		
	}

	@Override
	public void remove(Item t) {
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			System.out.println("The item has been removed from the database");
		}catch(Exception e) {
			em.getTransaction().rollback();		
		}
	}

	@Override
	public List<Item> getT() {
		List<Item> itemList = (List<Item>) em.createQuery("FROM Item").getResultList();
		return itemList;
	}

	@Override
	public Item getById(Integer id) {
		Item item = em.find(Item.class, id);
		if(item == null) {
			throw new EntityNotFoundException("Can't find Customer for ID" + id);
		}
		return item;
		
	}

	
}
