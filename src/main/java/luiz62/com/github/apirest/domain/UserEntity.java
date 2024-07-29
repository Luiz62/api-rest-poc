package luiz62.com.github.apirest.domain;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString
@Entity
public class UserEntity extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 8711669441955266954L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
}
