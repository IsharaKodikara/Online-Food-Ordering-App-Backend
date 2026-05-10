package lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);

}
