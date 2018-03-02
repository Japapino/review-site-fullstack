package reviewSiteFS;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewSiteFSMappingTest {
	@Resource
	private TestEntityManager entityManager; 
	
	@Resource
	private ReviewRepository reviewRepo; 
	
	@Resource
	private CategoryRepository CategoryRepo; 
	
	@Test
	public void shouldSaveAndLoadReview() {
		Review undertest = new Review("TEST","Test");
		undertest = reviewRepo.save(undertest); 
		long reviewId = undertest.getId(); 

		entityManager.flush();
		entityManager.clear();
		
		undertest = reviewRepo.findOne(reviewId);
		
		assertThat(undertest.getReview(), is("test"));
	}
	

}
