package luiz62.com.github.apirest.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import luiz62.com.github.apirest.domain.UserEntity;
import luiz62.com.github.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
@Profile(value = "local")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LocalConfig implements CommandLineRunner {

    public final UserRepository repository;

    public void mockUser() {
        UserEntity u1 = new UserEntity(null, "Luiz", "luiz@gmail.com", "123");
        UserEntity u2 = new UserEntity(null, "Valdir", "valdir@gmail.com", "123");
        List<UserEntity> userEntities = repository.saveAll(Arrays.asList(u1, u2));
        log.debug("Inserts users: {}", userEntities);
    }

    @Override
    public void run(String... args) {
        mockUser();
    }
}
