package ad.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ad.Customer;
import ad.Item;

public class ItemDAOImpl implements ItemDAO{

	
	EntityManager em;
	
	public ItemDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Item t) {
		
		
	}

	@Override
	public void update(Item t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Item t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> getT() {
		List<Item> itemList = (List<Item>) em.createQuery("FROM Item").getResultList();
		return itemList;
	}

	@Override
	public Item getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
