package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.playerClass.PlayerClassInsertDto;
import gr.project.dungeonFighter.dto.playerClass.PlayerClassReadOnlyDto;
import gr.project.dungeonFighter.dto.playerClass.PlayerClassUpdateDto;
import gr.project.dungeonFighter.model.static_data.PlayerClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = StatsMapper.class)
public interface PlayerClassMapper {

    PlayerClassReadOnlyDto toReadOnlyDto(PlayerClass playerClass);

    @Mapping(target = "stats", source = "stats")
    PlayerClass toEntity(PlayerClassInsertDto dto);

    @Mapping(target = "stats", source = "stats")
    void toUpdate(PlayerClassUpdateDto dto, PlayerClass entity);
}
