package gr.project.dungeonFighter.dto.stats;

import lombok.Data;

@Data
public class StatsReadOnlyDto {
    private Long id;
    private int strength;
    private int intelligence;
    private int stamina;
    private int dexterity;
    private int defense;
}
