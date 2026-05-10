package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service;

import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.FoodItemDTO;
import java.util.List;

public interface FoodService {
    FoodItemDTO createFood(FoodItemDTO dto);
    List<FoodItemDTO> getAllFoods();
    List<FoodItemDTO> getFoodsByCategory(Long categoryId);
    FoodItemDTO updateFood(Long id, FoodItemDTO dto);
    void deleteFood(Long id);
}
