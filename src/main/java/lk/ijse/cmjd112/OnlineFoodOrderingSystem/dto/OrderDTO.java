package lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private Long userId;
    private String status; // PLACED, PREPARING, DELIVERED, CANCELLED
    private List<OrderItemDTO> items;
}
