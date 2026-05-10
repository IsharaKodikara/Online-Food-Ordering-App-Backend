package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service;

import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.CartDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.CartItemDTO;

public interface CartService {
    CartDTO getCartByUser(Long userId);
    CartDTO addToCart(CartItemDTO dto);
    CartDTO updateCartItem(CartItemDTO dto);
    CartDTO removeItem(Long cartItemId);
}
