package gr.project.dungeonFighter.service;

import gr.project.dungeonFighter.core.exceptions.AppObjectAccessDeniedException;
import gr.project.dungeonFighter.core.exceptions.AppObjectAlreadyExistException;
import gr.project.dungeonFighter.core.exceptions.AppObjectNotFoundException;
import gr.project.dungeonFighter.dto.playerClass.PlayerClassInsertDto;
import gr.project.dungeonFighter.dto.playerClass.PlayerClassReadOnlyDto;
import gr.project.dungeonFighter.dto.playerClass.PlayerClassUpdateDto;
import gr.project.dungeonFighter.mapper.PlayerClassMapper;
import gr.project.dungeonFighter.model.PlayerClass;
import gr.project.dungeonFighter.repository.PlayerClassRepository;
import gr.project.dungeonFighter.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerClassService {

    private final PlayerClassMapper playerClassMapper;
    private final PlayerClassRepository playerClassRepository;
    private final PlayerRepository playerRepository;

    @Transactional
    public PlayerClassReadOnlyDto saveClass(PlayerClassInsertDto insertDto) {
        if (playerClassRepository.findByName(insertDto.getName()).isPresent()) {
            throw new AppObjectAlreadyExistException("PLAYER_CLASS", "The name " + insertDto.getName() + " already exists.");
        }

        PlayerClass playerClass = playerClassMapper.toEntity(insertDto);
        return playerClassMapper.toReadOnlyDto(playerClassRepository.save(playerClass));
    }

    @Transactional
    public PlayerClassReadOnlyDto updateClass(UUID classUuid, PlayerClassUpdateDto updateDto) {
        PlayerClass playerClass = playerClassRepository.findByUuid(classUuid)
                .orElseThrow(() -> new AppObjectNotFoundException("PLAYER_CLASS", "The player class was not found."));

        if (updateDto.getName() != null) {
            playerClassRepository.findByName(updateDto.getName())
                    .filter(existing -> !existing.getUuid().equals(classUuid))
                    .ifPresent(existing -> {
                        throw new AppObjectAlreadyExistException("PLAYER_CLASS", "The name " + updateDto.getName() + " already exists to another class.");
                    });
        }

        if (updateDto.getIsActive() != null && !updateDto.getIsActive()) {
            if (playerRepository.existsByPlayerClassUuid(classUuid)) {
                throw new AppObjectAccessDeniedException("PLAYER_CLASS", "Cannot deactivate a class assigned to players.");
            }
            playerClass.setIsActive(false);
        }

        playerClassMapper.toUpdate(updateDto, playerClass);
        return playerClassMapper.toReadOnlyDto(playerClassRepository.save(playerClass));
    }

    @Transactional
    public void deleteClass(UUID classUuid) {
        PlayerClass playerClass = playerClassRepository.findByUuid(classUuid)
                .orElseThrow(() -> new AppObjectNotFoundException("PLAYER_CLASS", "The player class was not found."));

        if (playerClass.getIsActive() != false) {
            throw new AppObjectAccessDeniedException("PLAYER_CLASS", "You cannot delete a class unless you first deactivate it.");
        }

        playerClassRepository.delete(playerClass);
    }


    @Transactional
    public Page<PlayerClassReadOnlyDto> getAllPlayerClassesPageable(Pageable pageable) {
        return playerClassRepository.findAll(pageable).map(playerClassMapper::toReadOnlyDto);
    }
}
