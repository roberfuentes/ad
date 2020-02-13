package ad.app;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ad.Category;
import ad.Item;
import ad.OrderLine;
import ad.Orders;
import ad.dao.CategoryDAOImpl;
import ad.dao.ItemDAOImpl;
import ad.dao.OrderLineDAOImpl;
import ad.dao.OrdersDAOImpl;

public class ItemMethods {
	static EntityManager em;
	static Scanner sn = new Scanner(System.in);
	
	
	
	public ItemMethods(EntityManager em) {
		this.em = em;
	}
	
	public static void listItems(boolean flagContinue) {
		System.out.println("\t");
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		List<Item> itemList = daoItem.getT();
		for(Item item:itemList) {
			System.out.println(item.toString());
		}
		System.out.println("\t");
		if(flagContinue)
			main.askContinue();
	}
	
	public static Item getById(int id) {
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		Item item = daoItem.getById(id);
		return item;
	}
	
	public static List<Item> returnListItems() {
		System.out.println("\t");
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		List<Item> itemList = daoItem.getT();

		return itemList;
	}
	
	public static void insertItem() throws InterruptedException {
		System.out.println("\t\t");
		CategoryDAOImpl daoCategory = new CategoryDAOImpl(em);
		ItemDAOImpl daoItem= new ItemDAOImpl(em);

		
		System.out.println("Give me a name for the new item");
		
		String name = sn.next();
		
		System.out.println("What's the unit price for the item: " + name);
		float price = sn.nextFloat();
		
		System.out.println("What category is the item from?");
		getListCategory();
		
		int id = sn.nextInt();
		
		Category category = daoCategory.getById(id);
		
		Item item = new Item(name, price, category);
		
		daoItem.insert(item);
		

		System.out.println("Esperando a listar...");
		Thread.sleep(5000);
		listItems(false);

		main.askContinue();
	}
	
	public static void updateItem() {
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		
		System.out.println("What order do you want to update?");
		listItems(false);
		int id = sn.nextInt();
		
		Item item = daoItem.getById(id);
		
		System.out.println("Do you want to change the actual name?: " + item.getName()+" (y/n)");
		String answer =sn.next();
		if(answer.equalsIgnoreCase("y")) {
			String name = sn.next();
			item.setName(name);
		}
		
		System.out.println("Do you want to change the price: "+ item.getPrice() + " (y/n)" );
		answer = sn.next();
		if(answer.equalsIgnoreCase("y")) {
			Float price = sn.nextFloat();
			item.setPrice(price);
		}
		//System.out.println("Do you want to change the category?:" + item.getCategory_id() + " (y/n)");
		daoItem.update(item);	
	}
	
	public static void removeItem() {
		System.out.println("What item do you want to remove");
		listItems(false);
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		int id = sn.nextInt();
		Item item = daoItem.getById(id);
		daoItem.remove(item);
		
	}
	
	
	public static void getListCategory() {
		System.out.println("\t");
		CategoryDAOImpl daoCategory = new CategoryDAOImpl(em);
		List<Category> categoryList = daoCategory.getT();
		for(Category category:categoryList) {
			System.out.println(category.getId() + ". " + category.getName());
		}
		System.out.println("\t");
	}
	
	
	

}