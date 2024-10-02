package EntranceTest.InternJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EntranceTest.InternJava.model.Category;
import EntranceTest.InternJava.model.Product;
import EntranceTest.InternJava.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> allProduct() {
		return productRepository.findAll();
	}

	public Product findById(long id) {
		return productRepository.findById(id).orElse(null);
	}

	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	// Tăng dần
	public List<Product> getAllProductByPriceAsc() {
		return productRepository.findAllByOrderByPriceAsc();
	}

	// Giảm dần
	public List<Product> getAllProductByPriceDesc() {
		return productRepository.findAllByOrderByPriceDesc();
	}

	public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
		return productRepository.findByPriceBetween(minPrice, maxPrice);
	}

}
