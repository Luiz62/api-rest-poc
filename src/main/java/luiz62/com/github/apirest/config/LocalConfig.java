package luiz62.com.github.apirest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "local")
public class LocalConfig {
}
