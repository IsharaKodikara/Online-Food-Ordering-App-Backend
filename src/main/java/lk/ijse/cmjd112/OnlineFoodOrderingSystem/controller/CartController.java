package lk.ijse.cmjd112.OnlineFoodOrderingSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.CartDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.CartItemDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartByUser(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<CartDTO> addToCart(@RequestBody CartItemDTO dto) {
        return ResponseEntity.ok(cartService.addToCart(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<CartDTO> updateCartItem(@RequestBody CartItemDTO dto) {
        return ResponseEntity.ok(cartService.updateCartItem(dto));
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<CartDTO> removeItem(@PathVariable Long cartItemId) {
        return ResponseEntity.ok(cartService.removeItem(cartItemId));
    }
}