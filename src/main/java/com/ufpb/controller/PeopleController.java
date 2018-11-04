package com.ufpb.controller;

import com.ufpb.model.People;
import com.ufpb.repository.PeopleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Usuarios", description = "Seta todas as operaçoes baseadas por pessoa.", tags = {"Usuarios"})
public class PeopleController {
    @Autowired
    private PeopleRepository repository;

    @GetMapping("/peoples")
    @ApiOperation("Retorna uma lista com todas as pessoas cadastradas na base")
    List<People> all() {
        return repository.findAll();
    }

    @GetMapping("/people/id/{id}")
    @ApiOperation("Consulta uma pessoa cadastrada na base usando o seu ID")
    People getPeopleById(@ApiParam("ID do usuario") @PathVariable String id) {
        return repository.findById(Long.parseLong(id)).get();
    }

    @GetMapping("/people/user/{username}")
    @ApiOperation("Consulta uma pessoa cadastrada na base atraves de seu username")
    People getPeopleByUsername(@ApiParam("Nome de usuario") @PathVariable String username) {
        return repository.findByUsername(username);
    }

    @GetMapping("/people/{username}/{password}")
    @ApiOperation("Consulta se um login e valido atraves de seu usuario e senha")
    People getLoginPeople(@ApiParam("Nome de Usuario") @PathVariable String username, @ApiParam("Senha do Usuario") @PathVariable String password){
        return repository.findByUserPass(username, password);
    }

    @GetMapping("/people/firstname/{firstname}")
    @ApiOperation("Retorna uma lista de pessoas baseadas em seu primeiro nome")
    List<People> getPeopleByFirstname(@ApiParam("Primeiro nome do Usuario") @PathVariable String firstname) {
        return repository.findByPeopleList(firstname);
    }

    @PostMapping("/people")
    @ApiOperation("Cria um usuario no banco de dados")
    void postNewUser(@ApiParam("Informaçoes necessarias para adiçao de usuario no banco de dados") @RequestBody People people) {
        repository.save(people);
    }
}
