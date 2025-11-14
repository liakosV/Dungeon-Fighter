package gr.project.dungeonFighter.model;

import gr.project.dungeonFighter.model.static_data.Stats;
import gr.project.dungeonFighter.model.static_data.StatsGrowth;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerClass extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @Embedded
    private Stats baseStats;

    @Embedded
    private StatsGrowth growth;
}
