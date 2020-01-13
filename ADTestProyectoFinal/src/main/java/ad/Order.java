package ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Order")
public class Order {
	
	@Id
	private int id;
	
	@Column
	private int datetime;
	
	@Column
	private int cost;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getDatetime() {
		return datetime;
	}

	public void setDatetime(int datetime) {
		this.datetime = datetime;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
	
	

}
