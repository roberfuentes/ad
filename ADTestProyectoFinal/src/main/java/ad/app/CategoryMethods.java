package ad.app;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ad.Category;
import ad.dao.CategoryDAOImpl;

public class CategoryMethods {
	
	
	static EntityManager em;
	private final static Scanner sn = new Scanner(System.in);
	
	public CategoryMethods(EntityManager em) {
		this.em = em;
	}
	
	public static void listCategory(boolean flagContinue) {
		System.out.println("\t");
		CategoryDAOImpl daoCategory = new CategoryDAOImpl(em);
		List<Category> categoryList = daoCategory.getT();
		for(Category category:categoryList) {
			System.out.println(category.getId() + ". " + category.getName());
		}
		System.out.println("\t");
		
		if(flagContinue)
			main.askContinue();
	}
	
	public static void insertCategory() {
		System.out.println("\t\t");
		CategoryDAOImpl daoCategory = new CategoryDAOImpl(em);
		
		System.out.println("Give me a name for the new category");
		
		String name = sn.next();
		
		
		Category category = new Category(name);
		daoCategory.insert(category);
	}
	public static void updateCategory() {
		System.out.println("What category do you want to update?");
		CategoryDAOImpl daoCategory = new CategoryDAOImpl(em);
		
		listCategory(false);
		int id = sn.nextInt();
		Category category = daoCategory.getById(id);
		
		System.out.println("What name do you want for the category?");
		String name = sn.next();
		
		category.setName(name);
		
		System.out.println("Do you want to change it? (y/n)");
		String answer = sn.next();
		
		if(answer.equalsIgnoreCase("y")) {
			daoCategory.update(category);
		}else {
			System.out.println("No se actualizará");
		}
		
	}
	
	public static void removeCategory() {
		System.out.println("What category do you want to delete?");
		CategoryDAOImpl daoCategory = new CategoryDAOImpl(em);
		
		listCategory(false);
		int id = sn.nextInt();
		Category category = daoCategory.getById(id);
		
		System.out.println("do you want to delete?\n" + category.toString());
		
		String answer = sn.next();
		if(answer.equalsIgnoreCase("y")) {
			daoCategory.remove(category);
		}else {
			System.out.println("No se borrará");
		}
		
	}
}
