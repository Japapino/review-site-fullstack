package reviewSiteFS;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

	Tag findByTag(String tagName);
	
	@Override
	Set<Tag> findAll();

}