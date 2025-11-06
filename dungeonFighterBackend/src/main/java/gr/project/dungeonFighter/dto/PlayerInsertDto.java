package gr.project.dungeonFighter.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerInsertDto {

    @NotEmpty(message = "The name cannot be empty.")
    private String name;

    @NotNull(message = "The class cannot be null.")
    private String playerClassName;

    @NotNull(message = "Stats must not be null.")
    private StatsInsertDto statsInsertDto;

}
