package lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private Long cartId;
    private Long userId;
    private List<CartItemDTO> cartItems;
}