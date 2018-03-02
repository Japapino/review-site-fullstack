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
		Category action = new Category("Action");
		Category mystery = new Category("Mystery"); 
		action = categoryRepo.save(action); 
		mystery = categoryRepo.save(mystery); 
		
		Review superman = new Review("Superman","Super review",action); 
		superman = reviewRepo.save(superman); 
		Review sherlock = new Review("Sherlock","Sherlock review",mystery); 
		sherlock = reviewRepo.save(sherlock); 
		
		
	}
	

}
