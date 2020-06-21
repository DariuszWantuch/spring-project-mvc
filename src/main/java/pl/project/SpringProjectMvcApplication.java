package pl.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringProjectMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectMvcApplication.class, args);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password[] = {"Admin1234","Client1234"};
		for (int i = 0; i < password.length; i++) {
			System.out.println(passwordEncoder.encode(password[i]));
		}
	}

}
