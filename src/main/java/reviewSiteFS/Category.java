package reviewSiteFS;

import java.util.Arrays;
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
	
	private Category() {
		
	}
	
	public Category(String type){
		this.type = type; 
	}
	
	public String getCategory() {
		return type; 
	}
	
	public long getId() {
		return id; 
	}
	
	public Collection<Review> getReviews(){
		return reviews; 
	}
	
	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; 
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Category) obj).id;
	}

}
