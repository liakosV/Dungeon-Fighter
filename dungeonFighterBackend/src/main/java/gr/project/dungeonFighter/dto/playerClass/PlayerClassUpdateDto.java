package gr.project.dungeonFighter.dto.playerClass;

import gr.project.dungeonFighter.dto.stats.StatsDto;
import lombok.Data;

@Data
public class PlayerClassUpdateDto {

    private String name;
    private String description;
    private StatsDto stats;
    private Boolean isActive;
}
