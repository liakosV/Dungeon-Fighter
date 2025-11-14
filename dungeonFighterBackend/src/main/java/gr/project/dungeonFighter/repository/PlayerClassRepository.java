package gr.project.dungeonFighter.repository;

import gr.project.dungeonFighter.model.PlayerClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerClassRepository extends JpaRepository<PlayerClass, Long> {
    Optional<PlayerClass> findByName(String name);
    Optional<PlayerClass> findByUuid(UUID uuid);
}
