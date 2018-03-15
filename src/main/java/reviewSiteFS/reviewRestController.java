package reviewSiteFS;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class reviewRestController {
	
	@Resource
	private ReviewRepository repo; 
	
	@RequestMapping("")
	public Iterable<Review> findallReviews(@RequestParam(defaultValue = "") String search, 
			@RequestParam(defaultValue= "") String advanced) {
		if (search.isEmpty()) {
			if (advanced.isEmpty()) {
				return repo.findAll();
			}
			return repo.findByDescriptionIgnoreCaseLike(advanced.replace('*','%'));
		}
		return repo.findByDescriptionIgnoreCaseContains(search);
	}
	
	@RequestMapping("/{id}")
	public Review findOneReview(@PathVariable long id) {
		return repo.findOne(id); 
	}

}
