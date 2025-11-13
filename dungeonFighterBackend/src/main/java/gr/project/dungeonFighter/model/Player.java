package gr.project.dungeonFighter.model;

import gr.project.dungeonFighter.model.static_data.PlayerClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private int level = 1;

    @Column(nullable = false)
    private int xp = 0;

    @Column(nullable = false)
    private int gold = 0;

    @ManyToOne
    @JoinColumn(name = "player_class_id")
    private PlayerClass playerClass;

    @Embedded
    private Stats stats;
}
