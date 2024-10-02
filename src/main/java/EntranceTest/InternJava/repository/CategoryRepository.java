package EntranceTest.InternJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import EntranceTest.InternJava.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
