package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.PlayerInsertDto;
import gr.project.dungeonFighter.dto.PlayerReadOnlyDto;
import gr.project.dungeonFighter.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = StatsMapper.class)
public interface PlayerMapper {

    @Mapping(target = "playerClassName", expression = "java(player.getPlayerClass().getName())")
    PlayerReadOnlyDto toReadOnlyDto(Player player);

    @Mapping(target = "playerClass", ignore = true)
    @Mapping(target = "stats", source = "statsInsertDto")
    Player toEntity(PlayerInsertDto dto);
}
