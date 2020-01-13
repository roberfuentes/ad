package ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Orders")
public class Orders {
	
	
	
	public Orders(int id, String order_date, float cost, Customer customer_id) {
		this.id = id;
		this.order_date = order_date;
		this.cost = cost;
		this.customer_id = customer_id;
	}

	@Id
	private int id;
	
	@Column
	private String order_date;
	
	@Column
	private float cost;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

}
