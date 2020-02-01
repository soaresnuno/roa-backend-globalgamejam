package rebuiltofavarum.roa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan( basePackages = "models")
@ComponentScan(basePackages = "controllers")
@EnableJpaRepositories (basePackages = "repositories")
@EnableTransactionManagement
//@EnableWebMvc
@RestController

public class RoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoaApplication.class, args);
	}

}
