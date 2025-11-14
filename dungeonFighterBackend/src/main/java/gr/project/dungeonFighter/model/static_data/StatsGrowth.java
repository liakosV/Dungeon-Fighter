package gr.project.dungeonFighter.model.static_data;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatsGrowth {
    private double strengthGrowth;
    private double intelligenceGrowth;
    private double staminaGrowth;
    private double dexterityGrowth;
    private double defenseGrowth;
}
