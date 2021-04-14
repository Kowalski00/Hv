package life.heevo.pttp.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		
		System.out.println(new BCryptPasswordEncoder().encode("Pi@8545195"));
		SpringApplication.run(Application.class, args);
	}
}
