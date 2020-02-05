package ad.app;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ad.OrderLine;
import ad.dao.OrderLineDAOImpl;

public class OrderLineMethods {

	static EntityManager em;
	static Scanner sn = new Scanner(System.in);

	public OrderLineMethods(EntityManager em) {
		super();
		this.em = em;
	}
	
	
	public static void listOrderLine(boolean flagContinue) {
		System.out.println("\t");
		OrderLineDAOImpl daoOrderLine = new OrderLineDAOImpl(em);
		
		System.out.println("Give me the id of the order");
		int id = sn.nextInt();
		
		
		List<OrderLine> orderLineList = daoOrderLine.getTFromOrder(13);
		for(OrderLine orderLine:orderLineList) {
			System.out.println(orderLine.toString());
		}
		System.out.println("\t");
		if(flagContinue) {
			main.askContinue();			
		}
		
		
	}


	public static void updateOrderLine() {
		listOrderLine(false);
		
		
		
	}


	public static void removeOrderLine() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
