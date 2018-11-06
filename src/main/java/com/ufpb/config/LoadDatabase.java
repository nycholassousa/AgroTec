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
import java.util.Random;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PeopleRepository peopleRepository, AdRepository adRepository) {
        return args -> {
            Random gerador = new Random();

            People[] peoples = new People[11];
            for (int i = 0; i < peoples.length; i++) {
                peoples[i] = new People("username" + i, "password" + i, "firstname" + i, "lastname" + i, "email" + i +"@email.com", "1111-111" + i, "https://img.ibxk.com.br/2015/08/27/27151441599410.jpg");
                peopleRepository.save(peoples[i]);
            }

            Ad[] ads = new Ad[11];
            for (int i = 0; i < ads.length; i++) {
                int aux = gerador.nextInt(4) + 1;
                ads[i] = new Ad("Titulo " + i, "Descrição " + i, String.valueOf(aux), "01/01/1970", peoples[i], "https://blog.petnanet.com.br/wp-content/uploads/2017/09/106262-voce-sabe-como-cuidar-de-uma-calopsita-aprenda-aqui-700x465.jpg");
                adRepository.save(ads[i]);
            }
        };
    }
}
