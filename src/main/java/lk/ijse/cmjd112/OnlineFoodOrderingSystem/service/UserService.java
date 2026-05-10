package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service;

import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.UserDTO;
import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO dto);
    void deleteUser(Long id);
}