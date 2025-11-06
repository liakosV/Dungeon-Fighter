package gr.project.dungeonFighter.repository;

import gr.project.dungeonFighter.model.static_data.PlayerClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerClassRepository extends JpaRepository<PlayerClass, Long> {
    Optional<PlayerClass> findByName(String name);
}
