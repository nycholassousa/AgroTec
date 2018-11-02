package com.cntv.Agrotec.controller;

import com.cntv.Agrotec.model.People;
import com.cntv.Agrotec.repository.PeopleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeopleController {
    @Autowired
    private PeopleRepository repository;

    @GetMapping("/peoples")
    List<People> all() {
        return repository.findAll();
    }

    @GetMapping("/people/id/{id}")
    People getPeopleById(@PathVariable String id) {
        return repository.findById(Long.parseLong(id)).get();
    }

    @GetMapping("/people/user/{username}")
    People getPeopleByUsername(@PathVariable String username) {
        return repository.findByUsername(username);
    }

    @GetMapping("/people/{username}/{password}")
    People getLoginPeople(@PathVariable String username, @PathVariable String password){
        return repository.findByUserPass(username, password);
    }
}
