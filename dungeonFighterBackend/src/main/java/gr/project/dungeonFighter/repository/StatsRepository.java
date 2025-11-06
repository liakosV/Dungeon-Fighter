package gr.project.dungeonFighter.repository;

import gr.project.dungeonFighter.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Long> {
}
