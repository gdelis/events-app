package com.gdelis.events;

import com.gdelis.events.repository.EventsRepository;
import com.gdelis.events.repository.dao.EventDetailsDAO;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Bean
   CommandLineRunner runner(final EventsRepository repository) {
      return args -> {
         EventDetailsDAO event = new EventDetailsDAO(1, "title-1", LocalDateTime.now(), null);
         repository.save(event);
         event = new EventDetailsDAO(2, "title-2", LocalDateTime.now(), null);
         repository.save(event);
         event = new EventDetailsDAO(3, "title-2", LocalDateTime.of(2024, 1, 1, 12, 0), null);
         repository.save(event);

         repository.findByTitle("title-2")
                   .forEach(System.out::println);

         EventDetailsDAO eventDetailsDAO =
             repository.findDistinctByTitleAndStartDate("title-2", LocalDateTime.of(2024, 1, 1, 12, 0))
                       .get();
         System.out.println("eventDetailsDAO = " + eventDetailsDAO);
      };
   }
}
