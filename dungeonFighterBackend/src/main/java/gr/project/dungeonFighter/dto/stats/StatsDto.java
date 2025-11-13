package gr.project.dungeonFighter.dto.stats;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatsDto {

    @NotNull
    private Integer strength;

    @NotNull
    private Integer intelligence;

    @NotNull
    private Integer stamina;

    @NotNull
    private Integer dexterity;

    @NotNull
    private Integer defense;
}
