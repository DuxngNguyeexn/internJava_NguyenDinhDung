package EntranceTest.InternJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EntranceTest.InternJava.model.Category;
import EntranceTest.InternJava.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> allCategory(){
		return categoryRepository.findAll();
	}
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	public void save(Category category) {
		categoryRepository.save(category);
	}
}
