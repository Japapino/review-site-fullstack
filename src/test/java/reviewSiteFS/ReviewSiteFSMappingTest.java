package reviewSiteFS;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.hamcrest.Matcher;
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
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("TEST");
		category = categoryRepo.save(category);
		long categoryId = category.getId();

		entityManager.flush();
		entityManager.clear();

		category = categoryRepo.findOne(categoryId);

		assertThat(category.getCategory(), is("TEST"));
	}

	@Test
	public void shouldSaveReviewToCategoryRelationship() {
		Category category = new Category("TEST");
		category = categoryRepo.save(category);

		Review review = new Review("TEST", "test", category);
		review = reviewRepo.save(review);
		long reviewId = review.getId();
//		Review review2 = new Review("TEST2", "test2", category);
//		review2 = reviewRepo.save(review2);
//		long reviewId2 = review2.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
//		review2 = reviewRepo.findOne(reviewId2);
		assertThat(review.getCategory(), is(category));
		// assertThat(category.getReviews(), containsInAnyOrder(review, review2));
	}

	@Test
	public void shouldSaveAndLoadTag() {
		Tag tag = tagRepo.save(new Tag("test"));

		long tagId = tag.getId();
		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getTag(), is("test"));
	}
}
