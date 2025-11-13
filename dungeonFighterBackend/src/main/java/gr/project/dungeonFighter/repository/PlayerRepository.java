package gr.project.dungeonFighter.repository;

import gr.project.dungeonFighter.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByUuid(UUID uuid);
    Optional<Player> findByName(String name);

    boolean existsByPlayerClassUuid(UUID uuid);
}
