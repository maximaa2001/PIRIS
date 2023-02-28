package by.bsuir.bankSystem.entity.dto;

import lombok.Getter;

@Getter
public class MessageDto {
    private final String message;

    public MessageDto(String message) {
        this.message = message;
    }
}
