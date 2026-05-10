package lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto;

import lombok.Data;

@Data
public class CartItemDTO {

    private String foodName;
    private double price;
    private Long id;
    private Long cartId;
    private Long foodItemId;
    private int quantity;
}