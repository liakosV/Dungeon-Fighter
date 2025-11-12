package gr.project.dungeonFighter.dto.user;

import lombok.Data;

@Data
public class UserChangePasswordDto {
    private String oldPassword;
    private String newPassword;
}
