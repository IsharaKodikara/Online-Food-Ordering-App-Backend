package lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto;

import lombok.Data;

@Data
public class FoodItemDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String status; // AVAILABLE / OUT_OF_STOCK
    private Long categoryId;
}
