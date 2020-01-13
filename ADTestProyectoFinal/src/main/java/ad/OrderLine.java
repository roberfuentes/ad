package ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="OrderLine")
public class OrderLine {
	
	
	
	public OrderLine(int id, Orders order_id, Item item_id, float price, int quantity, float cost) {
		this.id = id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.price = price;
		this.quantity = quantity;
		this.cost = cost;
	}


	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Orders order_id;
	
	
	//@OneToOne
	private Item item_id;
	
	
	@Column(name="price")
	private float price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="cost")
	private float cost;

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Orders order_id) {
		this.order_id = order_id;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public float getCost() {
		return cost;
	}



	public void setCost(float cost) {
		this.cost = cost;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", order_id=" + order_id + ", price=" + price + ", quantity=" + quantity
				+ ", cost=" + cost + "]";
	}
	
	
	
	
	
	

}
