package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.PaymentDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.PaymentService;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public PaymentDTO processPayment(PaymentDTO dto) {

        Order order = orderRepository.findById(dto.getOrderId()).orElseThrow();

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(dto.getAmount());
        payment.setStatus(dto.getStatus());

        paymentRepository.save(payment);

        dto.setId(payment.getId());
        return dto;
    }

    @Override
    public PaymentDTO getPaymentByOrder(Long orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId);

        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setOrderId(orderId);
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus());

        return dto;
    }
}
