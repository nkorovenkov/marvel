package marvel.com.marvel.settings;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Marvel", description = "Marvel",
    version = "1.0", contact = @Contact(name = "Korovenkov Nikita", email = "korovenkov.nik@mail.ru")))
public class SwaggerConfiguration {

}
