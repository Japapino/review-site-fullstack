package reviewSiteFS;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewSiteFSController {

		@Resource
		ReviewRepository reviewRepo;
		
		@Resource
		CategoryRepository categoryRepo; 
		
		@Resource
		TagRepository tagRepo; 
		
		
		@RequestMapping("reviews")
		public String getAllReviews(Model model, Model model1) {
			Collection<Tag> tags = tagRepo.findAll(); 
			model.addAttribute("reviews",reviewRepo.findAll());
			model.addAttribute("tags",tags); 
			return "reviews";
		}
		
		@RequestMapping("review")
		public String getAReview(@RequestParam long id, Model model) {
			Collection<Tag> selectedTags = reviewRepo.findOne(id).getTags();  
			model.addAttribute("selectedTags", selectedTags);
			model.addAttribute("review",reviewRepo.findOne(id));
			return "review";
		}
		
		@RequestMapping("categories")
		public String getCategories(Model model) {
			model.addAttribute("categories",categoryRepo.findAll());
			return "categories";
		}
		
		
		@RequestMapping("category")
		public String getReviews(@RequestParam long id, Model model) {
			Category selectedCategory = categoryRepo.findOne(id); 
			model.addAttribute("selectedCategory", selectedCategory); 
			model.addAttribute("reviews", reviewRepo.findByCategory(selectedCategory)); 
			return "category";
		}
		
		
		@RequestMapping("/sort-reviews")
		public String sortAllCourses(Model model) {
			model.addAttribute("reviews", reviewRepo.findAllByOrderByNameAsc());
			return "reviews"; 
		}
		
		@RequestMapping("/find-by-tag")
			public String findReviewByTag(String tagName, Model model) {
				Tag tag = tagRepo.findByTag(tagName);
				model.addAttribute("reviews", reviewRepo.findByTags(tag));
				return "/tag"; 
			}
		
		@RequestMapping("/add-tag")
			public String addTag(@RequestParam long id, String tagName) {
			Review review = reviewRepo.findById(id); 
			Tag tag = tagRepo.findByTag(tagName); 
			
			if (tag == null) {
				tag = new Tag(tagName); 
				tagRepo.save(tag); 
			}
			
			review.addTag(tag);
			reviewRepo.save(review); 
			
			return "reviews";
		}
}



