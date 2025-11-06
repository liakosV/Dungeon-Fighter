package gr.project.dungeonFighter.dto;

import gr.project.dungeonFighter.model.static_data.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserInsertDto {

    @NotNull(message = "The username must not be empty.")
    private String username;

    @NotEmpty(message = "The password cannot be empty.")
    private String password;

    @Email(message = "The email is invalid.")
    private String email;

    @NotBlank(message = "The role must not be empty.")
    private Role role;
}
