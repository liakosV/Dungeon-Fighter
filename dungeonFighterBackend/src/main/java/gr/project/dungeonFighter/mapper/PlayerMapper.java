package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.player.PlayerInsertDto;
import gr.project.dungeonFighter.dto.player.PlayerReadOnlyDto;
import gr.project.dungeonFighter.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StatsMapper.class, PlayerClassMapper.class})
public interface PlayerMapper {

    PlayerReadOnlyDto toReadOnlyDto(Player player);

    @Mapping(target = "playerClass", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "stats", ignore = true)
    @Mapping(target = "level", ignore = true)
    @Mapping(target = "xp", ignore = true)
    @Mapping(target = "gold", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Player toEntity(PlayerInsertDto dto);
}
