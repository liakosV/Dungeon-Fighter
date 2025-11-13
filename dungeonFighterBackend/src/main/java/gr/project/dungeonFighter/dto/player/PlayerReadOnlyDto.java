package gr.project.dungeonFighter.dto.player;

import gr.project.dungeonFighter.dto.stats.StatsDto;
import lombok.Data;

import java.util.UUID;

@Data
public class PlayerReadOnlyDto {
    private UUID uuid;
    private String name;
    private String playerClassName;
    private int level;
    private int xp;
    private int gold;
    private StatsDto stats;
}
