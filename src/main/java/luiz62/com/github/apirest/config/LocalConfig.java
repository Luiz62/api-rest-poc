package luiz62.com.github.apirest.config;

import lombok.RequiredArgsConstructor;
import luiz62.com.github.apirest.domain.UserEntity;
import luiz62.com.github.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile(value = "local")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LocalConfig {

    public final UserRepository repository;

    @Bean
    public void mockUser() {
        UserEntity u1 = new UserEntity(null, "Luiz", "luiz@gmail.com", "123");
        UserEntity u2 = new UserEntity(null, "Valdir", "valdir@gmail.com", "123");
        repository.saveAll(Arrays.asList(u1, u2));
    }
}
