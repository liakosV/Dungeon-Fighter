package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.stats.StatsDto;
import gr.project.dungeonFighter.model.Stats;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatsMapper {

    StatsDto toDto(Stats stats);

    Stats toEntity(StatsDto dto);
}
