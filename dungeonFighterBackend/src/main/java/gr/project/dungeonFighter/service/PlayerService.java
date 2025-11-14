package gr.project.dungeonFighter.service;

import gr.project.dungeonFighter.core.exceptions.AppObjectAccessDeniedException;
import gr.project.dungeonFighter.core.exceptions.AppObjectAlreadyExistException;
import gr.project.dungeonFighter.core.exceptions.AppObjectInvalidArgumentException;
import gr.project.dungeonFighter.core.exceptions.AppObjectNotFoundException;
import gr.project.dungeonFighter.dto.player.PlayerInsertDto;
import gr.project.dungeonFighter.dto.player.PlayerReadOnlyDto;
import gr.project.dungeonFighter.mapper.PlayerMapper;
import gr.project.dungeonFighter.mapper.StatsMapper;
import gr.project.dungeonFighter.model.Player;
import gr.project.dungeonFighter.model.PlayerClass;
import gr.project.dungeonFighter.model.User;
import gr.project.dungeonFighter.model.static_data.Stats;
import gr.project.dungeonFighter.model.static_data.StatsGrowth;
import gr.project.dungeonFighter.repository.PlayerClassRepository;
import gr.project.dungeonFighter.repository.PlayerRepository;
import gr.project.dungeonFighter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerClassRepository playerClassRepository;
    private final UserRepository userRepository;
    private final PlayerMapper playerMapper;
    private final StatsMapper statsMapper;

    /**
     * Saves a new player in the system based on the provided data. The player is associated
     * with the currently authenticated user. Performs various validations before saving,
     * such as ensuring that a user has only one player, the player's name is unique,
     * and the player class is active.
     *
     * @param insertDto the data used to create the player, including name, player class,
     *                  and stats information
     * @return a read-only view of the saved player, including its details such as
     *         name, class, level, and stats
     * @throws AppObjectNotFoundException if the authenticated user or the specified player class
     *                                    is not found in the system
     * @throws AppObjectAlreadyExistException if the user already has a player or the provided
     *                                        player name already exists
     * @throws AppObjectAccessDeniedException if trying to create a player with an inactive class
     */
    @Transactional
    public PlayerReadOnlyDto savePlayer(PlayerInsertDto insertDto) {
        String username = SecurityContextHolder.getContext()
                                               .getAuthentication()
                                               .getName();

        User user = userRepository.findByUsername(username)
               .orElseThrow(() -> new AppObjectNotFoundException("User", "The user was not found."));

        // Enforce: One player per user
        if (playerRepository.existsByUser(user)) {
            throw new AppObjectAlreadyExistException("PLAYER", "The user already has a player.");
        }

        if (playerRepository.findByName(insertDto.getName()).isPresent()) {
            throw new AppObjectAlreadyExistException("PLAYER", "The name " + insertDto.getName() + " already exists.");
        }

        PlayerClass playerClass = playerClassRepository.findByName(insertDto.getPlayerClassName())
                .orElseThrow(() -> new AppObjectNotFoundException("PLAYER_CLASS", "The player class was not found."));

        if (!playerClass.getIsActive()) {
            throw new AppObjectAccessDeniedException("PLAYER_CLASS", "Cannot create a player with an inactive class.");
        }

        Player player = new Player();
        player.setUser(user);
        player.setPlayerClass(playerClass);
        player.setName(insertDto.getName());
        player.setStats(statsMapper.copy(playerClass.getBaseStats()));

        player.setLevel(1);
        player.setXp(0);
        player.setGold(0);

        playerRepository.save(player);
        return playerMapper.toReadOnlyDto(player);
    }

    public PlayerReadOnlyDto getPlayer(UUID playerUuid) {
        Player player = playerRepository.findByUuid(playerUuid)
                .orElseThrow(() -> new AppObjectNotFoundException("PLAYER", "The player was not found."));

        Stats totalStats = computeTotalStats(player);

        PlayerReadOnlyDto dto = playerMapper.toReadOnlyDto(player);
        dto.setStats(statsMapper.toDto(totalStats));

        return dto;
    }

    private Stats computeTotalStats(Player player) {
        PlayerClass playerClass = player.getPlayerClass();
        Stats base = playerClass.getBaseStats();
        StatsGrowth growth = playerClass.getGrowth();
        int level = player.getLevel();

        Stats result = new Stats();
        result.setStrength((int) (base.getStrength() + (level - 1) * growth.getStrengthGrowth()));
        result.setIntelligence((int) (base.getIntelligence() + (level - 1) * growth.getIntelligenceGrowth()));
        result.setStamina((int) (base.getStamina() + (level - 1) * growth.getStaminaGrowth()));
        result.setDexterity((int) (base.getDexterity() + (level - 1) * growth.getDexterityGrowth()));
        result.setDefense((int) (base.getDefense() + (level - 1) * growth.getDefenseGrowth()));

        // Need it later when Item entity will be added.
//        if (player.getItems() != null) {
//            for (Item item : player.getItems()) {
//                result.setStrength(result.getStrength() + item.getStrengthBonus());
//                result.setIntelligence(result.getIntelligence() + item.getIntelligenceBonus());
//                result.setStamina(result.getStamina() + item.getStaminaBonus());
//                result.setDexterity(result.getDexterity() + item.getDexterityBonus());
//                result.setDefense(result.getDefense() + item.getDefenseBonus());
//            }

        return result;
    }
}
