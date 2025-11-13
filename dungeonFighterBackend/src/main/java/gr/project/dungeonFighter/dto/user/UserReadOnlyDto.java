package gr.project.dungeonFighter.dto.user;

import gr.project.dungeonFighter.dto.player.PlayerReadOnlyDto;
import lombok.Data;

import java.util.UUID;

@Data
public class UserReadOnlyDto {

    private UUID uuid;
    private String username;
    private String email;
    private Boolean isActive;
    private String roleName;
    private PlayerReadOnlyDto player;
}
