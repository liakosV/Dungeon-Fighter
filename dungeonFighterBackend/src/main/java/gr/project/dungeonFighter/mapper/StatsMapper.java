package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.stats.StatsDto;
import gr.project.dungeonFighter.model.static_data.Stats;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatsMapper {

    StatsDto toDto(Stats stats);

    Stats toEntity(StatsDto dto);

    default Stats copy(Stats stats){
        if (stats == null) return null;
        Stats copy = new Stats();
        copy.setStrength(stats.getStrength());
        copy.setIntelligence(stats.getIntelligence());
        copy.setStamina(stats.getStamina());
        copy.setDexterity(stats.getDexterity());
        copy.setDefense(stats.getDefense());
        return copy;
    }
}
