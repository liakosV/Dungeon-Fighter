package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.playerClass.PlayerClassInsertDto;
import gr.project.dungeonFighter.dto.playerClass.PlayerClassReadOnlyDto;
import gr.project.dungeonFighter.model.static_data.PlayerClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerClassMapper {

    @Mapping(target = "classType", expression = "java(playerClass.getType().name())")
    PlayerClassReadOnlyDto toReadOnlyDto(PlayerClass playerClass);

    @Mapping(target = "classType", expression = "java(ClassType.valueOf(dto.getClassType().toUpperCase()))")
    PlayerClass toEntity(PlayerClassInsertDto dto);
}
