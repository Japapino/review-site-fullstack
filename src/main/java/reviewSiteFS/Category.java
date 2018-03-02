package reviewSiteFS;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private long id; 
	
	@OneToMany(mappedBy="category")
	private Collection<Review> reviews;
	private String type; 
	
	public Category() {}
	
	public Category(String type){
		this.type = type; 
	}
	
	public String getCategory() {
		return type; 
	}
	
	public Long getId() {
		return id; 
	}
	
	public Collection<Review> getReviews(){
		return reviews; 
	}

}
