package lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long id;
    private Long foodItemId;
    private int quantity;
    private double price;
}
