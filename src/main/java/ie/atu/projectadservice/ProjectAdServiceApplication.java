package ie.atu.projectadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjectAdServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectAdServiceApplication.class, args);
	}

}
