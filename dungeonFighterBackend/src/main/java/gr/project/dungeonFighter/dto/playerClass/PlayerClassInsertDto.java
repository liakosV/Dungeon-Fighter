package gr.project.dungeonFighter.dto.playerClass;

import gr.project.dungeonFighter.dto.stats.StatsDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerClassInsertDto {

    @NotEmpty(message = "The name cannot be empty.")
    private String name;

    @NotEmpty(message = "The description cannot be empty.")
    private String description;

    @NotNull(message = "The stats must not be null.")
    private StatsDto stats;
}
