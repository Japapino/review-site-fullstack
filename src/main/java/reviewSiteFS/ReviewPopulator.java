package reviewSiteFS;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator  implements CommandLineRunner{
	
	private Logger log = LoggerFactory.getLogger(ReviewPopulator.class); 

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
		Review sherlock = new Review("Sherlock","Sherlock review",historicalDocumentary); 
		Review batman = new Review("Batman","Batman review",sportsDocumentary); 

		sherlock.setImage("./images/sherlock.jpg");
		superman.setImage("./images/superman.png");
		batman.setImage("./images/batman.jpg");

		superman = reviewRepo.save(superman); 
		sherlock = reviewRepo.save(sherlock); 
		batman = reviewRepo.save(batman); 
		
		
		log.info("Review found with findByCategory('memoir'):");
		log.info("--------------------------------------------");
		for (Review review : reviewRepo.findByCategoryId(memoir.getId())) {
			log.info(review.getName());
		}
		log.info("");
	}
	

}
