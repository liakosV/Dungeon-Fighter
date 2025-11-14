package gr.project.dungeonFighter.dto.playerClass;

import gr.project.dungeonFighter.dto.stats.StatsDto;
import gr.project.dungeonFighter.dto.stats.StatsGrowthDto;
import lombok.Data;

import java.util.UUID;

@Data
public class PlayerClassReadOnlyDto {

    private UUID uuid;
    private String name;
    private String description;
    private StatsDto stats;
    private StatsGrowthDto growthDto;
}
