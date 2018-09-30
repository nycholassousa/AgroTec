package com.cntv.Agrotec.controller;

import com.cntv.Agrotec.model.People;
import com.cntv.Agrotec.repository.PeopleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeopleController {
    private final PeopleRepository repository;

    PeopleController(PeopleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/peoples")
    List<People> all() {
        return repository.findAll();
    }
}
