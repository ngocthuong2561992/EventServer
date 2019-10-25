package com.cd.stmty;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.cd.stmty")
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
public class STMTYApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(STMTYApplication.class, args);
	}

	@Bean
	FirebaseApp initFirebase() throws IOException {
		if (FirebaseApp.getApps().isEmpty()) {
			System.out.println("FirebaseApp initial new one!");
			InputStream serviceAccount = new ClassPathResource("event-service-account.json").getInputStream();
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://event-17841.firebaseio.com").build();
			FirebaseApp initializeApp = FirebaseApp.initializeApp(options);
			return initializeApp;
		}
		System.out.println("FirebaseApp already exist!");
		return FirebaseApp.getApps().get(0);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
