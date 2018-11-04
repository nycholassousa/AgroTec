package com.ufpb.service;

import com.ufpb.model.People;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeopleService {
    void save(People people);

    People findByUsername(String username);
    People findByUserPass(String username, String password);
    List<People> findByPeopleList(String firstname);
}
