package gr.project.dungeonFighter.dto;

import lombok.Data;

@Data
public class UserReadOnlyDto {

    private Long id;
    private String username;
    private String email;
    private Boolean isActive;
    private String roleName;
    private PlayerReadOnlyDto player;
}
