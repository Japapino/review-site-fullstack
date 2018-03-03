package reviewSiteFS;
import java.util.Collection;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{
	
	Collection<Review> findByCategoryId(long id); 
	
	@Override
	Set<Review> findAll();
}
