package gr.project.dungeonFighter.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserReadOnlyDto {

//    private Long id;
    private UUID uuid;
    private String username;
    private String email;
    private Boolean isActive;
    private String roleName;
    private PlayerReadOnlyDto player;
}
