package com.cntv.Agrotec.service;

import com.cntv.Agrotec.model.People;

public interface PeopleService {
    void save(People people);

    People findByUsername(String username);
    People findByUserPass(String username, String password);
}
