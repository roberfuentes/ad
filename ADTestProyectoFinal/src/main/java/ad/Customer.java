package ad;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Customer")
public class Customer {
	
	@Id
	private int id;
	
	public Customer() {
		//Default
	}
	
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Column(name="name")
	private String name;
	
	
	@OneToMany(mappedBy = "customer_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Orders> orders = new ArrayList<Orders>(); 
	
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + "]";
	}
	
	
	public void addOrder(Orders order) {
		orders.add(order);
		order.setCustomer_id(this);
	}
	
	public void removeOrder(Orders order) {
		orders.remove(order);
		order.setCustomer_id(null);
	}
	
	
	public void showPedidos() {
		for(Orders order: orders) {
			System.out.println(order);
		}
	}
	
	

}
