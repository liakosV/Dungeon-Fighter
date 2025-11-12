package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.stats.StatsInsertDto;
import gr.project.dungeonFighter.dto.stats.StatsReadOnlyDto;
import gr.project.dungeonFighter.model.Stats;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatsMapper {

    StatsReadOnlyDto toReadOnlyDto(Stats stats);

    Stats toEntity(StatsInsertDto dto);
}
