package reviewSiteFS;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Category category; 
	
	@ManyToMany
	private Collection<Tag> tags; 
	
	private String name; 
	private String review; 
	private String image; 
	
	@SuppressWarnings("unused")
	private Review() {}
	
	public Review(String name, String review, Category category, Tag...tags) {
		this.name = name;
		this.review = review; 
		this.category = category; 
		this.tags = Arrays.asList(tags); 
	}
	
	public void setImage(String path) {
		this.image = path; 
	}
	
	public long getId() {
		return id; 
	}

	public String getName() {
		return name;
	}
	
	public String getReview() {
		return review; 
	}
	
	public Category getCategory(){
		return category; 
	}
	
	public Collection<Tag> getTags(){
		return tags; 
	}
	
	public String getImage() {
		return image; 
	}
	
	

	public void addTag(Tag newTag) {
		tags.add(newTag);
	}

	public void removeTag(Tag tag) {
		tags.remove(tag); 
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

		return id == ((Review) obj).id;
	}


}
