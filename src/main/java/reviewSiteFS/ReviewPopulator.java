package reviewSiteFS;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator  implements CommandLineRunner{
	
	@Resource
	private ReviewRepository reviewRepo; 
	
	@Resource
	private CategoryRepository categoryRepo; 
	
	@Resource
	private TagRepository tagRepo; 
	
	
	@Override
	public void run(String... args) throws Exception {
		Category memoir = new Category("Memoir");
		Category historicalDocumentary = new Category("Historical Documentary"); 
		Category sportsDocumentary = new Category("Sports Documentary"); 
		memoir = categoryRepo.save(memoir); 
		historicalDocumentary = categoryRepo.save(historicalDocumentary); 
		sportsDocumentary = categoryRepo.save(sportsDocumentary); 
		
		Tag action = new Tag("Action"); 
		Tag scifi= new Tag("Sci-Fi"); 
		Tag mystery = new Tag("Mystery"); 
		Tag documentary = new Tag("Documentary"); 
		Tag sports = new Tag("Sports"); 
		Tag greatSoundtrack = new Tag("Great Soundtrack"); 
		action = tagRepo.save(action); 
		scifi = tagRepo.save(scifi); 
		mystery = tagRepo.save(mystery); 
		documentary = tagRepo.save(documentary); 
		sports = tagRepo.save(sports); 
		greatSoundtrack = tagRepo.save(greatSoundtrack); 
		
		
		Review superman = new Review("Superman","Super review",memoir,action,scifi,greatSoundtrack); 
		Review sherlock = new Review("Sherlock","Sherlock review",historicalDocumentary,documentary,mystery,action); 
		Review batman = new Review("Batman","Batman review",sportsDocumentary,action,sports); 

		sherlock.setImage("./images/sherlock.jpg");
		superman.setImage("./images/superman.png");
		batman.setImage("./images/batman.jpg");
		
		superman = reviewRepo.save(superman); 
		sherlock = reviewRepo.save(sherlock); 
		batman = reviewRepo.save(batman); 
		
	}
	

}
