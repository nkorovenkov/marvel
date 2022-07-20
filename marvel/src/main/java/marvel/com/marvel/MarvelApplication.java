package marvel.com.marvel;

import marvel.com.marvel.settings.SpringBootSecurityJwtApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApplication.class, args);
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}
}
