package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service;

import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO processPayment(PaymentDTO dto);
    PaymentDTO getPaymentByOrder(Long orderId);
}