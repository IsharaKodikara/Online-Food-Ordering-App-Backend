package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service;

import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(Long userId);
    List<OrderDTO> getOrdersByUser(Long userId);
    OrderDTO updateOrderStatus(Long orderId, String status);
}
