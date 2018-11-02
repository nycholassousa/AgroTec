package com.cntv.Agrotec.service.ServiceImpl;

import com.cntv.Agrotec.model.People;
import com.cntv.Agrotec.repository.PeopleRepository;
import com.cntv.Agrotec.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public void save(People people) {

    }

    @Override
    public People findByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }

    @Override
    public People findByUserPass(String username, String password) {
        return peopleRepository.findByUserPass(username, password);
    }
}
