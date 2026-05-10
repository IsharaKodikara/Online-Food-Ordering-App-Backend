package lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUserId(Long userId);

}
