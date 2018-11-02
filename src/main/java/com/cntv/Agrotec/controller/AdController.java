package com.cntv.Agrotec.controller;

import com.cntv.Agrotec.model.Ad;
import com.cntv.Agrotec.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdController {

    @Autowired
    private AdRepository adRepository;

    @GetMapping("/ads")
    List<Ad> all() {
        return adRepository.findAll();
    }
}
