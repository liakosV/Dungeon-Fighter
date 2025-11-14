package gr.project.dungeonFighter.dto.playerClass;

import gr.project.dungeonFighter.dto.stats.StatsDto;
import gr.project.dungeonFighter.dto.stats.StatsGrowthDto;
import lombok.Data;

@Data
public class PlayerClassUpdateDto {

    private String name;
    private String description;
    private StatsDto stats;
    private StatsGrowthDto growthDto;
    private Boolean isActive;
}
