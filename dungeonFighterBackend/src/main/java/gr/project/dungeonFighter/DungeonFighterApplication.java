package gr.project.dungeonFighter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DungeonFighterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DungeonFighterApplication.class, args);
	}

}
