package gr.project.dungeonFighter.dto.player;

import gr.project.dungeonFighter.dto.stats.StatsReadOnlyDto;
import lombok.Data;

import java.util.UUID;

@Data
public class PlayerReadOnlyDto {
//    private Long id;
    private UUID uuid;
    private String name;
    private String playerClassName;
    private int level;
    private int xp;
    private int gold;
    private StatsReadOnlyDto stats;
}
