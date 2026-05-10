package lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.request;

import lombok.Data;

@Data
public class RegisterRequestDTO {

    private String name;
    private String email;
    private String password;
    private String role; // ADMIN or CUSTOMER
}