package lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto;

import lombok.Data;

@Data
public class PaymentDTO {

    private Long id;
    private Long orderId;
    private double amount;
    private String status; // PENDING, COMPLETED, FAILED
}