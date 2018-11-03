package com.cntv.Agrotec.controller;

import com.cntv.Agrotec.exception.ResourceNotFoundException;
import com.cntv.Agrotec.model.Ad;
import com.cntv.Agrotec.model.People;
import com.cntv.Agrotec.repository.AdRepository;
import com.cntv.Agrotec.repository.PeopleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(description = "Seta todas as operaçoes relativo a anuncios.")
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
        adRepository.save(ad);
    }


}
