package luiz62.com.github.apirest.resources.expections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timestamp;

    private Integer status;

    private String error;

    private String path;
}
