package gr.project.dungeonFighter.model;

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
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int strength;
    private int intelligence;
    private int stamina;
    private int dexterity;
    private int defense;

    @OneToOne(mappedBy = "stats", fetch = FetchType.LAZY)
    private Player player;

}
