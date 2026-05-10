package lk.ijse.cmjd112.OnlineFoodOrderingSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.FoodItemDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.FoodService;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodItemDTO> createFood(@RequestBody FoodItemDTO dto) {
        return ResponseEntity.ok(foodService.createFood(dto));
    }

    @GetMapping
    public ResponseEntity<List<FoodItemDTO>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<FoodItemDTO>> getFoodsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(foodService.getFoodsByCategory(categoryId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItemDTO> updateFood(
            @PathVariable Long id,
            @RequestBody FoodItemDTO dto
    ) {
        return ResponseEntity.ok(foodService.updateFood(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
