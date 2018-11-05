package com.ufpb.config;

import com.ufpb.model.Ad;
import com.ufpb.model.People;
import com.ufpb.repository.AdRepository;
import com.ufpb.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PeopleRepository peopleRepository, AdRepository adRepository) {
        return args -> {
            //Preload People

            People[] peoples = new People[11];
            for (int i = 0; i < peoples.length; i++) {
                peoples[i] = new People("username" + i, "password" + i, "firstname" + i, "lastname" + i, "email" + i +"@email.com", "1111-111" + i, "http://url/image/" + i + ".png");
                peopleRepository.save(peoples[i]);
            }

            Ad[] ads = new Ad[11];
            for (int i = 0; i < ads.length; i++) {
                ads[i] = new Ad("Titulo " + i, "Descrição " + i, "01/01/1970", peoples[i], "http://url/image/" + i + ".png");
                adRepository.save(ads[i]);
            }
        };
    }
}
