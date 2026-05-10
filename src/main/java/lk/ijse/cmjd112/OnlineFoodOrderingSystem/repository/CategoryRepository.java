package lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
