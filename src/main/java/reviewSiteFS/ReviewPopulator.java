package reviewSiteFS;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator  implements CommandLineRunner{

	@Resource
	private ReviewRepository reviewRepo; 
	
	@Resource
	private CategoryRepository categoryRepo; 
	
	@Override
	public void run(String... args) throws Exception {
		Category memoir = new Category("Memoir");
		Category historicalDocumentary = new Category("Historical Documentary"); 
		Category sportsDocumentary = new Category("Sports Documentary"); 
		memoir = categoryRepo.save(memoir); 
		historicalDocumentary = categoryRepo.save(historicalDocumentary); 
		sportsDocumentary = categoryRepo.save(sportsDocumentary); 
		
		Review superman = new Review("Superman","Super review",memoir); 
		superman = reviewRepo.save(superman); 
		Review sherlock = new Review("Sherlock","Sherlock review",historicalDocumentary); 
		sherlock = reviewRepo.save(sherlock); 
		Review batman = new Review("Batman","Batman review",sportsDocumentary); 
		batman = reviewRepo.save(batman); 

		
		sherlock.setImage("./images/sherlock.jpg");
		superman.setImage("./images/superman.png");
		batman.setImage("./images/batman.jpg");
		
	}
	

}
