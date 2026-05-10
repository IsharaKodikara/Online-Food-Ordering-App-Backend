package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.OrderDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderItemRepository orderItemRepository;

   @Override
    public OrderDTO placeOrder(Long userId) {

    User user = userRepository.findById(userId)
            .orElseThrow();

    Cart cart = cartRepository.findByUserId(userId);

    Order order = new Order();

    order.setUser(user);

    order.setStatus("PLACED");

    orderRepository.save(order);

    List<OrderItem> orderItems =
            cart.getItems()
                    .stream()
                    .map(cartItem -> {

                        OrderItem item =
                                new OrderItem();

                        item.setOrder(order);

                        item.setFoodItem(
                                cartItem.getFoodItem()
                        );

                        item.setQuantity(
                                cartItem.getQuantity()
                        );

                        item.setPrice(
                                cartItem.getFoodItem().getPrice()
                        );

                        return item;

                    }).toList();

    orderItemRepository.saveAll(orderItems);

    order.setItems(orderItems);

    orderRepository.save(order);

    cartItemRepository.deleteAll(cart.getItems());

    OrderDTO dto = new OrderDTO();

    dto.setId(order.getId());

    dto.setUserId(userId);

    dto.setStatus(order.getStatus());

    return dto;
}

    @Override
    public List<OrderDTO> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId)
                .stream().map(order -> {
                    OrderDTO dto = new OrderDTO();
                    dto.setId(order.getId());
                    dto.setUserId(userId);
                    dto.setStatus(order.getStatus());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(status);
        orderRepository.save(order);

        OrderDTO dto = new OrderDTO();
        dto.setId(orderId);
        dto.setStatus(status);
        return dto;
    }
}
