package lk.ijse.cmjd112.OnlineFoodOrderingSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.PaymentDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentDTO> processPayment(@RequestBody PaymentDTO dto) {
        return ResponseEntity.ok(paymentService.processPayment(dto));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentDTO> getPaymentByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentService.getPaymentByOrder(orderId));
    }
}