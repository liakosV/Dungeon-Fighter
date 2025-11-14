package gr.project.dungeonFighter.repository;

import gr.project.dungeonFighter.model.static_data.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Long> {
}
