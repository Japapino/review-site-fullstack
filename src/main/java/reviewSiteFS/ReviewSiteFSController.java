package reviewSiteFS;

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
		CategoryRepository tagRepo; 
		
		
		@RequestMapping(value = "reviews")
		public String getAllReviews(Model model, Model model1) {
			model.addAttribute("reviews",reviewRepo.findAll());
			return "reviews";
		}
		
		@RequestMapping("review")
		public String getAReview(@RequestParam long id, Model model) {
			model.addAttribute("reviews", reviewRepo.findOne(id));
			return "review";
		}
		
		@RequestMapping(value="categories")
		public String getCategories(Model model) {
			model.addAttribute("categories",categoryRepo.findAll());
			return "categories";
		}
		
//		@RequestMapping("category")
//		public String getMemoirs(@RequestParam long id, Model model) {
//			model.addAttribute("category",categoryRepo.findOne(id));
//			return "category";
//		}
}


