package com.gdelis.events;

import com.gdelis.events.repository.EventsRepository;
import com.gdelis.events.repository.dao.EventDetailsDAO;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Bean
   CommandLineRunner runner(EventsRepository repository) {
      return args -> {
         EventDetailsDAO event = new EventDetailsDAO(1, "title", LocalDateTime.now(), null);
         repository.save(event);
      };
   }
}
