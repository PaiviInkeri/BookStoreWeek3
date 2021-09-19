package Syksy21.BookStoreWeek3.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	//yhden suhde moneen -relaatio book-tauluun, JPA mappaa categoryn avulla (ks. Book.java)
	//cascadetype all tarkoittaa, että jos kategoria poistetaan, se poistuu myös kirjan tiedoista 
	//eli viite-eheys säilyy
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	
	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Category [id = " + id + ", Category name = " + name + "]";
		}

}
