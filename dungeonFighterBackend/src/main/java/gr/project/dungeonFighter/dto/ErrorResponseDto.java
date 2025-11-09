package gr.project.dungeonFighter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String code;
    private String message;
    private int StatusCode;
    private LocalDateTime localDateTime;
}
