package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.FoodItemDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.FoodService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public FoodItemDTO createFood(FoodItemDTO dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        FoodItem food = new FoodItem();
        food.setName(dto.getName());
        food.setDescription(dto.getDescription());
        food.setPrice(dto.getPrice());
        food.setStatus(dto.getStatus());
        food.setCategory(category);

        foodRepository.save(food);
        dto.setId(food.getId());

        return dto;
    }

    @Override
    public List<FoodItemDTO> getAllFoods() {
        return foodRepository.findAll().stream().map(food -> {
            FoodItemDTO dto = new FoodItemDTO();
            dto.setId(food.getId());
            dto.setName(food.getName());
            dto.setDescription(food.getDescription());
            dto.setPrice(food.getPrice());
            dto.setStatus(food.getStatus());
            dto.setCategoryId(food.getCategory().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<FoodItemDTO> getFoodsByCategory(Long categoryId) {
        return foodRepository.findByCategoryId(categoryId)
                .stream().map(food -> {
                    FoodItemDTO dto = new FoodItemDTO();
                    dto.setId(food.getId());
                    dto.setName(food.getName());
                    dto.setDescription(food.getDescription());
                    dto.setPrice(food.getPrice());
                    dto.setStatus(food.getStatus());
                    dto.setCategoryId(categoryId);
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public FoodItemDTO updateFood(Long id, FoodItemDTO dto) {
        FoodItem food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        food.setName(dto.getName());
        food.setDescription(dto.getDescription());
        food.setPrice(dto.getPrice());
        food.setStatus(dto.getStatus());

        foodRepository.save(food);
        return dto;
    }

    @Override
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
