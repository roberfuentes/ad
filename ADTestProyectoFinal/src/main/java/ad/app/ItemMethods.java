package ad.app;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ad.Item;
import ad.OrderLine;
import ad.dao.ItemDAOImpl;
import ad.dao.OrderLineDAOImpl;

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
	public static void listItemsWithoutContinue() {
		System.out.println("\t");
		ItemDAOImpl daoItem = new ItemDAOImpl(em);
		List<Item> itemList = daoItem.getT();
		for(Item item:itemList) {
			System.out.println(item.toString());
		}
		
		System.out.println("\t");
	}
	
	
	
	

}
