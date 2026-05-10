package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service;

import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.request.LoginRequestDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.request.RegisterRequestDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.response.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO register(RegisterRequestDTO request);
    AuthResponseDTO login(LoginRequestDTO request);
}
