package gr.project.dungeonFighter.dto.playerClass;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PlayerClassInsertDto {

    @NotEmpty(message = "The name cannot be empty.")
    private String name;

    @NotEmpty(message = "The description cannot be empty.")
    private String description;

    @NotEmpty(message = "The class type cannot be empty.")
    private String classType;
}
