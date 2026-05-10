package lk.ijse.cmjd112.OnlineFoodOrderingSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.request.LoginRequestDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.request.RegisterRequestDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.response.AuthResponseDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
