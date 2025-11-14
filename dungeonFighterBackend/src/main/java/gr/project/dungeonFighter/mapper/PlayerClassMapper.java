package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.playerClass.PlayerClassInsertDto;
import gr.project.dungeonFighter.dto.playerClass.PlayerClassReadOnlyDto;
import gr.project.dungeonFighter.dto.playerClass.PlayerClassUpdateDto;
import gr.project.dungeonFighter.model.PlayerClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {StatsMapper.class, StatsGrowthMapper.class})
public interface PlayerClassMapper {

    PlayerClassReadOnlyDto toReadOnlyDto(PlayerClass playerClass);

//    @Mapping(target = "stats", source = "stats")
    @Mapping(target = "growth", source = "growthDto")
    PlayerClass toEntity(PlayerClassInsertDto dto);

//    @Mapping(target = "stats", source = "stats", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "growth", source = "growthDto", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toUpdate(PlayerClassUpdateDto dto, @MappingTarget PlayerClass entity);
}
