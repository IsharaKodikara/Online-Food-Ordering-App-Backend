package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.request.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.response.*;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.User;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.exception.ResourceNotFoundException;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.exception.UnauthorizedException;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.UserRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public AuthResponseDTO register(RegisterRequestDTO request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        userRepository.save(user);

        return new AuthResponseDTO("dummy-token", user.getRole(),user.getId());
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
        throw new UnauthorizedException("Invalid credentials");
}

        return new AuthResponseDTO("dummy-token", user.getRole(),user.getId());
    }
}
