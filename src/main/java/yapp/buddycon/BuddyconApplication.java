package yapp.buddycon;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class BuddyconApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuddyconApplication.class, args);
	}

}
