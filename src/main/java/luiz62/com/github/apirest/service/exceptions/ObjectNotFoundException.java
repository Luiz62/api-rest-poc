package luiz62.com.github.apirest.service.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -6660968059360526401L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

}

