package com.cntv.Agrotec.service;

import com.cntv.Agrotec.model.People;
import org.springframework.stereotype.Service;

@Service
public interface PeopleService {
    void save(People people);

    People findByUsername(String username);
    People findByUserPass(String username, String password);
}
