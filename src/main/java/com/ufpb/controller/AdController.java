package com.ufpb.controller;

import com.ufpb.model.Ad;
import com.ufpb.model.People;
import com.ufpb.repository.AdRepository;
import com.ufpb.repository.PeopleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Anuncios", description = "Seta todas as operaçoes relativo a anuncios.", tags = {"Anuncios"})
public class AdController {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping("/ads")
    @ApiOperation("Retorna uma lista com todos os anuncios na base")
    List<Ad> all() {
        return adRepository.findAll();
    }

    @PostMapping("/ads")
    @ApiOperation("Adiciona um anuncio, baseado no ID da pessoa")
    void createAd(@RequestBody Ad ad) {

        People people = peopleRepository.findById(ad.getPeople_id()).orElse(null);
        ad.setPeople(people);

        adRepository.save(ad);
    }

    @GetMapping("/ads/regiao/{regiao}")
    @ApiOperation("Retorna uma lista baseada por regiao")
    List<Ad> findRegions(@PathVariable String regiao) {
        return adRepository.findAdByRegiao(regiao);
    }
}
