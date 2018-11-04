package com.ufpb.config;

import com.ufpb.model.People;
import com.ufpb.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PeopleRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new People("user1", "password1", "firstName1", "lastname1", "email1@email.com", "1111-1111", "google.com")));
        };
    }
}
