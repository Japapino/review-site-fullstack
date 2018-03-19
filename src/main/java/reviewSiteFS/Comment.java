package reviewSiteFS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id; 
	private String user; 
	private String text; 
	
	@ManyToOne
	private Review review; 

	public Comment () {}
	
	public Comment(String user, String text) {
		this.user = user; 
		this.text = text; 
	}
	
	public String getUser() {
		return user;
	}
	
	public String getText() {
		return text; 
	}
	
	public Review getReview() {
		return review; 
	}
	
	

}
