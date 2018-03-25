package reviewSiteFS;
import java.util.Collection;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{
	
	Collection<Review> findByCategory(Category category); 
	Collection<Review> findByTags(Tag tag); 
	Collection<Review> findAllByOrderByNameAsc();
	
	@Override
	Set<Review> findAll();
	Review findByName(String reviewName);
	Review findById(Long id);
}
