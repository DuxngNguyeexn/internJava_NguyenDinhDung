package EntranceTest.InternJava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import EntranceTest.InternJava.model.Category;
import EntranceTest.InternJava.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByCategory(Category category);
	 List<Product> findAllByOrderByPriceAsc(); 
	 List<Product> findAllByOrderByPriceDesc();
	 List<Product> findByPriceBetween(Double minPrice, Double maxPrice); 
}
