package by.bsuir.bankSystem.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private final String message;
    private String field;

    public MessageDto(String message) {
        this.message = message;
    }

    public MessageDto(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
