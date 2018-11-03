package com.cntv.Agrotec.controller;

import com.cntv.Agrotec.model.Ad;
import com.cntv.Agrotec.repository.AdRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(description = "Seta todas as operaçoes relativo a anuncios.")
public class AdController {

    @Autowired
    private AdRepository adRepository;

    @GetMapping("/ads")
    @ApiOperation("Retorna uma lista com todos os anuncios na base")
    List<Ad> all() {
        return adRepository.findAll();
    }
}
