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

            People[] peoples1 = new People[5];
            peoples1[0] = new People("caio", "caio", "Caio", "Marcelo", "caiomcg@gmail.com", "83911111111", "https://scontent.frec10-1.fna.fbcdn.net/v/t1.0-9/15941174_1610327608981623_1952268802427833851_n.jpg?_nc_cat=108&_nc_ht=scontent.frec10-1.fna&oh=b754df73b6008cc9c2de16f9ac870481&oe=5C82CDF9");
            peoples1[1] = new People("nycholas", "nycholas", "Nycholas", "de Sousa", "nycholas@live.com", "83922222222", "https://scontent.frec10-1.fna.fbcdn.net/v/t1.0-9/11813379_1659635650940746_1378281156469120823_n.jpg?_nc_cat=101&_nc_ht=scontent.frec10-1.fna&oh=1c12c3ee2eb229c2fbd946e1302a8e2f&oe=5C8AACE6");
            peoples1[2] = new People("thiago", "thiago", "Thiago", "Luiz", "thiago.luiz@lavid.ufpb.br", "83933333333", "https://scontent.frec10-1.fna.fbcdn.net/v/t1.0-9/11026214_1023510014347002_8947323924973015120_n.jpg?_nc_cat=106&_nc_ht=scontent.frec10-1.fna&oh=f9cfb9fa9421749d09cdd6b4d486e858&oe=5C42329D");
            peoples1[3] = new People("victor", "victor", "Victor", "Batista", "rotciv18@hotmail.com", "83944444444", "https://scontent.frec10-1.fna.fbcdn.net/v/t1.0-1/30652385_2106410726043429_494501650803453206_n.jpg?_nc_cat=107&_nc_ht=scontent.frec10-1.fna&oh=c879beff100439cc78302d6528acd479&oe=5C408575");
            peoples1[4] = new People("gledson", "gledson", "Gledson", "Elias", "gledson@ci.ufpb.br", "83955555555", "http://www.ufpb.br/sites/default/files/Gledson%20Silveira.jpg");

            for (int i = 0; i < peoples1.length; i++) {
                peopleRepository.save(peoples1[i]);
            }

            Ad[] ads1 = new Ad[5];
            ads1[0] = new Ad("Peixes", "Vendo piadas para consumo, 10 reais o quilo", "1", "05/11/2018", peoples1[0], "http://www.clubedapescaria.com.br/img/peixes/lambari-piaba.jpg");
            ads1[1] = new Ad("Casal de Calopsita", "Vendo casal de calopsita reprodutor, 100 reais ou um moto g", "2", "06/11/2018", peoples1[1], "http://1.bp.blogspot.com/-O_ygzXwQOgI/UEUdYJYR7BI/AAAAAAAACNo/WZuNiIDgqww/s1600/images.jpeg");
            ads1[2] = new Ad("Macaxeira e Batata Doce", "1 real o quilo", "2", "05/11/2018", peoples1[2], "https://www.mundoboaforma.com.br/wp-content/uploads/2014/05/batata-doce-620x330.jpg");
            ads1[3] = new Ad("Trigo", "24 reais a saca", "3", "04/11/2018", peoples1[3], "http://qbacanaalimentos.com.br/images/empresa/trigo.jpg");
            ads1[4] = new Ad("Trator", "Trator para colheira, contatar pelo telefone", "4", "06/11/2018", peoples1[4], "https://cdn.pixabay.com/photo/2016/08/02/10/31/combine-harvester-1562989_960_720.jpg");

            for (int i = 0; i < ads1.length; i++) {
                adRepository.save(ads1[i]);
            }
        };
    }
}
