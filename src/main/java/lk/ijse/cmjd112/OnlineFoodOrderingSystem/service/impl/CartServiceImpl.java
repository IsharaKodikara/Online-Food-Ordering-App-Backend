package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.CartDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.CartItemDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.Cart;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.CartItem;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.FoodItem;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.User;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.CartItemRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.CartRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.FoodRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.UserRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.CartService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    private final FoodRepository foodRepository;

    private final UserRepository userRepository;

    @Override
    public CartDTO getCartByUser(Long userId) {

        Cart cart = cartRepository.findByUserId(userId);

        if (cart == null) {

            return new CartDTO(
                    null,
                    userId,
                    new ArrayList<>()
            );
        }

        List<CartItemDTO> items =
                cart.getItems()
                        .stream()
                        .map(item -> {

                            CartItemDTO dto =
                                    new CartItemDTO();

                            dto.setId(item.getId());

                            dto.setCartId(cart.getId());

                            dto.setFoodItemId(
                                    item.getFoodItem().getId()
                            );

                            dto.setFoodName(
                                    item.getFoodItem().getName()
                            );

                            dto.setPrice(
                                    item.getFoodItem().getPrice()
                            );

                            dto.setQuantity(
                                    item.getQuantity()
                            );

                            return dto;

                        }).toList();

        return new CartDTO(
                cart.getId(),
                userId,
                items
        );
    }

    @Override
    public CartDTO addToCart(CartItemDTO dto) {

        User user = userRepository
                .findById(1L)
                .orElseThrow();

        Cart cart =
                cartRepository.findByUserId(
                        user.getId()
                );

        if (cart == null) {

            cart = new Cart();

            cart.setUser(user);

            cart = cartRepository.save(cart);
        }

        FoodItem food =
                foodRepository.findById(
                        dto.getFoodItemId()
                ).orElseThrow();

        CartItem item = new CartItem();

        item.setCart(cart);

        item.setFoodItem(food);

        item.setQuantity(1);

        cartItemRepository.save(item);

        return getCartByUser(user.getId());
    }

    @Override
    public CartDTO updateCartItem(CartItemDTO dto) {

        CartItem item =
                cartItemRepository.findById(
                        dto.getId()
                ).orElseThrow();

        item.setQuantity(dto.getQuantity());

        cartItemRepository.save(item);

        return getCartByUser(
                item.getCart()
                        .getUser()
                        .getId()
        );
    }

    @Override
    public CartDTO removeItem(Long cartItemId) {

        CartItem item =
                cartItemRepository.findById(
                        cartItemId
                ).orElseThrow();

        Long userId =
                item.getCart()
                        .getUser()
                        .getId();

        cartItemRepository.delete(item);

        return getCartByUser(userId);
    }
}