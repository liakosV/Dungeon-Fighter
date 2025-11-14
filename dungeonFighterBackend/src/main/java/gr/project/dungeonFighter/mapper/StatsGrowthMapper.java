package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.stats.StatsGrowthDto;
import gr.project.dungeonFighter.model.static_data.StatsGrowth;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatsGrowthMapper {

    StatsGrowthDto toDto(StatsGrowth growth);
    StatsGrowth toEntity(StatsGrowthDto growthDto);
}
