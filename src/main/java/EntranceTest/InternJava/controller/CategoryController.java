package EntranceTest.InternJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EntranceTest.InternJava.model.Category;
import EntranceTest.InternJava.model.ResponseObj;
import EntranceTest.InternJava.service.CategoryService;

@RestController
@RequestMapping(path = "api/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@GetMapping("")
	public List<Category> allCategories(){
		return categoryService.allCategory();
	}
	@GetMapping("/{id}")
	ResponseEntity<ResponseObj> findById(@PathVariable long id) {
		Category category = categoryService.findById(id);
		if(category != null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObj("ok","Query successfully",category));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObj("404","can not found with id: "+ id, null));
		}
	}
}
