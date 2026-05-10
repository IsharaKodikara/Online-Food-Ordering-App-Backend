package lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.FoodItem;

import java.util.List;

public interface FoodRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findByCategoryId(Long categoryId);

}
