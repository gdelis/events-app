package com.gdelis.events;

import com.gdelis.events.repository.EventsRepository;
import com.gdelis.events.repository.dao.EventDetailsDAO;
import java.time.LocalDateTime;
import java.util.stream.Stream;
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

         var eventsAtLocation = Stream.of(1, 2, 3, 4, 5)
                                      .map(s -> EventDetailsDAO.builder()
                                                               .id(s)
                                                               .title("title-" + s)
                                                               .location("location")
                                                               .startDate(LocalDateTime.of(2024, 1, s, 12, 0))
                                                               .build())
                                      .toList();
         repository.saveAll(eventsAtLocation);

         EventDetailsDAO event = EventDetailsDAO.builder()
                                                .id(6)
                                                .title("title")
                                                .location("new-location")
                                                .startDate(LocalDateTime.of(2024, 1, 1, 12, 0))
                                                .build();
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
