package gr.project.dungeonFighter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stats {
    private Integer strength = 0;
    private Integer intelligence = 0;
    private Integer stamina = 0;
    private Integer dexterity = 0;
    private Integer defense = 0;
}
