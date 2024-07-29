package luiz62.com.github.apirest.service.exceptions;

import java.io.Serial;

public class DataIntegratyViolationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6017901304502718549L;

    public DataIntegratyViolationException(String message) {
        super(message);
    }

}

