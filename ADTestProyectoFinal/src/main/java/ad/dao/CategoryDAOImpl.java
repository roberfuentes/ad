package ad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import ad.Category;
import ad.Customer;

public class CategoryDAOImpl implements CategoryDAO{

	EntityManager em;
	public CategoryDAOImpl(EntityManager em) {
		this.em = em;
	}
	@Override
	public void insert(Category t) {
		
		
	}

	@Override
	public void update(Category t) {
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
	public void remove(Category t) {
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			System.out.println("The category has been removed from the database");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("The category coudln't be removed");
		}
		
	}

	@Override
	public List<Category> getT() {
		List<Category> categoryList = (List<Category>)em.createQuery("FROM cateogry").getResultList(); 
		return categoryList;
	}

	@Override
	public Category getById(Integer id) {
		Category category = em.find(Category.class, id);
		if(category == null) {
			throw new EntityNotFoundException("Can't find Category for ID" + id);
		}
		return category;
	}
	
	
	

}
