package ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Item")
public class Item {
	
	
	public Item() {
		super();
	}

	public Item(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
		//this.category_id = category_id;
	}

	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private float price;

	/*@ManyToOne
	@JoinColumn(name="category_id")
	private Category category_id;*/

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
}
