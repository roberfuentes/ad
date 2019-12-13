package ad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	    
	private String name;
		 
	@OneToMany(mappedBy = "student",
			cascade = CascadeType.ALL, 
		    orphanRemoval = true)
	private List<Laptop> laptops= new ArrayList<>();
	
		    
	
		    
    //GETTERS AND SETTERS
    public String getName() {
		return name;
		}
	public void setName(String name) {
		this.name = name;
		}
	
	
	public int getId() {
		return id;
		}
	
	public void setId(int id) {
		this.id = id;
		}
	
	public List<Laptop> getLaptops() {
		return laptops;
		}
	
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
		}
			
	public void addLaptop(Laptop laptop) {
		laptops.add(laptop);
		laptop.setStudent(this);			
		}
			
	public void removeLaptop(Laptop laptop) {
		laptops.remove(laptop);
		laptop.setStudent(null);
			}
}