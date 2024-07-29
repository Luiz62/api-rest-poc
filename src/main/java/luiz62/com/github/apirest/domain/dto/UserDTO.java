package luiz62.com.github.apirest.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import luiz62.com.github.apirest.domain.AbstractDomain;

import java.io.Serial;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString
public class UserDTO extends AbstractDomain {

    @Serial
    private static final long serialVersionUID = -481846163519604657L;

    private Long id;

    private String name;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
