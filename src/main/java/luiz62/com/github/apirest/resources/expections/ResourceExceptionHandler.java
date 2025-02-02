package luiz62.com.github.apirest.resources.expections;

import jakarta.servlet.http.HttpServletRequest;
import luiz62.com.github.apirest.service.exceptions.DataIntegratyViolationException;
import luiz62.com.github.apirest.service.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
        var status = HttpStatus.NOT_FOUND;
        return getStandardErrorResponseEntity(status, ex.getMessage(), request);
    }

    @ExceptionHandler(DataIntegratyViolationException.class)
    public ResponseEntity<StandardError> dataIntegratyViolation(DataIntegratyViolationException ex, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        return getStandardErrorResponseEntity(status, ex.getMessage(), request);
    }

    private static ResponseEntity<StandardError> getStandardErrorResponseEntity(HttpStatus status, String ex, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), ex, request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
