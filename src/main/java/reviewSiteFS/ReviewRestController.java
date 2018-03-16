package reviewSiteFS;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ReviewRestController {
	
	@Resource
	private ReviewRepository reviewRepo; 
	
	@Resource TagRepository tagRepo; 
	
//	@RequestMapping("")
//	public Iterable<Review> findallReviews(@RequestParam(defaultValue = "") String search, 
//			@RequestParam(defaultValue= "") String advanced) {
//		if (search.isEmpty()) {
//			if (advanced.isEmpty()) {
//				return reviewRepo.findAll();
//			}
//			return reviewRepo.findByDescriptionIgnoreCaseLike(advanced.replace('*','%'));
//		}
//		return reviewRepo.findByDescriptionIgnoreCaseContains(search);
//	}
	
	@RequestMapping("/{id}")
	public Review findOneReview(@PathVariable long id) {
		return reviewRepo.findOne(id); 
	}
	


	//add tag
//	@RequestMapping("/add-tag")
//	public Collection<Review> addTag(String tagName, String reviewName) {
//		Review review = reviewRepo.findByName(reviewName);
//		Tag tag = tagRepo.findByTag(tagName);
//		
//		if (tag == null) {
//			tag = new Tag(tagName);
//			tagRepo.save(tag); 
//		}
//		
//		return reviewRepo.findByTags(tag); 
//	}
	
	//remove tags
	
	
	//add review

}
