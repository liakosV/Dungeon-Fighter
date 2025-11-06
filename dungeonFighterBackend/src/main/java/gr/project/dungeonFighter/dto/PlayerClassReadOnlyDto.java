package gr.project.dungeonFighter.dto;

import lombok.Data;

@Data
public class PlayerClassReadOnlyDto {

    private Long id;
    private String name;
    private String description;
    private String classType;
}
