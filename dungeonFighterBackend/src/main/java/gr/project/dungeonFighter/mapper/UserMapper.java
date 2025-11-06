package gr.project.dungeonFighter.mapper;

import gr.project.dungeonFighter.dto.UserInsertDto;
import gr.project.dungeonFighter.dto.UserReadOnlyDto;
import gr.project.dungeonFighter.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public interface UserMapper {

    @Mapping(target = "roleName", expression = "java(user.getRole().name())")
    UserReadOnlyDto toReadOnlyDto(User user);

    @Mapping(target = "role", expression = "java(Role.valueOf(dto.getRoleName().toUpperCase()))")
    @Mapping(target = "player", ignore = true)
    User toEntity(UserInsertDto dto);
}
