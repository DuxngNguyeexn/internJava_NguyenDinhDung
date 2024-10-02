package EntranceTest.InternJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import EntranceTest.InternJava.model.Category;
import EntranceTest.InternJava.model.Product;
import EntranceTest.InternJava.model.ResponseObj;
import EntranceTest.InternJava.service.CategoryService;
import EntranceTest.InternJava.service.ProductService;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {
	@Autowired
	ProductService productService ;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	List<Product> findAll(){
		return productService.allProduct();
	}
	@GetMapping("/{id}")
	ResponseEntity<ResponseObj> findById(@PathVariable long id) {
		Product product = productService.findById(id);
		if(product != null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObj("ok","Query successfully",product));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObj("404","can not found with id: "+ id, null));
		}
	}
	@GetMapping("/category/{id}")
	List<Product> findByCategory(@PathVariable long id){
		Category category = categoryService.findById(id);
		return productService.findByCategory(category);
	}
	@GetMapping("/priceAsc")
	List<Product> getAllProductByPriceAsc(){
		return productService.getAllProductByPriceAsc();
	}
	@GetMapping("/priceDesc")
	List<Product> getAllProductByPriceDesc(){
		return productService.getAllProductByPriceDesc();
	}
	 @GetMapping("/byPriceRange") 
	List<Product> getProductsByPriceRanger(@RequestParam Double minPrice, @RequestParam Double maxPrice){
		return productService.getProductsByPriceRange(minPrice, maxPrice);
	}
}
