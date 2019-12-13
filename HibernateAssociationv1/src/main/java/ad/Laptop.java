package ad;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;


@Entity(name="laptop")
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
		
		@NaturalId
		@Column(name="`name`")
		private String name;
		
		
		@ManyToOne
		private Student student;
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public Student getStudent() {
			return student;
		}
	
		public void setStudent(Student student) {
			this.student = student;
		}
	
		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		
		public boolean equals(Object o) {
			if ( this == o ) {
				return true;
			}
			if ( o == null || getClass() != o.getClass() ) {
				return false;
			}
			Laptop laptop = (Laptop) o;
			return Objects.equals( name, laptop.name);
		}
	
		
		public int hashCode() {
			return Objects.hash(name);
		}
		

}
