package com.ufpb.service.ServiceImpl;

import com.ufpb.model.People;
import com.ufpb.repository.PeopleRepository;
import com.ufpb.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<People> findByPeopleList(String firstname) {
        return peopleRepository.findByPeopleList(firstname);
    }
}
