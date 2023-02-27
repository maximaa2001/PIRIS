package by.bsuir.bankSystem.exception.handler;

import by.bsuir.bankSystem.entity.dto.MessageDto;
import by.bsuir.bankSystem.exception.BadRequestException;
import by.bsuir.bankSystem.exception.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler({ConflictException.class})
    public MessageDto conflict(RuntimeException e) {
        return new MessageDto(e.getMessage());
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class})
    public MessageDto badRequest(RuntimeException e) {
        return new MessageDto(e.getMessage());
    }
}
