package lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
