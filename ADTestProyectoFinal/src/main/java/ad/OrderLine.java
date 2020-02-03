package ad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="OrderLine")
public class OrderLine {
	
	
	
	public OrderLine() {
		super();
	}


	public OrderLine(int id, Orders order_id, Item item_id, float price, int quantity, float cost) {
		this.id = id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.price = price;
		this.quantity = quantity;
		this.cost = cost;
	}
	public OrderLine(Orders order_id, Item item_id, float price, int quantity, float cost) {
		this.order_id = order_id;
		this.item_id = item_id;
		this.price = price;
		this.quantity = quantity;
		this.cost = cost;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="order_id")
	private Orders order_id;
	
	
	@OneToOne
	@JoinColumn(name="item_id")
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

	
	public Item getItem_id() {
		return item_id;
	}


	public void setItem_id(Item item_id) {
		this.item_id = item_id;
	}


	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", order_id=" + order_id + ", item_id=" + item_id + ", price=" + price
				+ ", quantity=" + quantity + ", cost=" + cost + "]";
	}


	
	
	
	
	
	

}
