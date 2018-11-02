package com.cntv.Agrotec.repository;

import com.cntv.Agrotec.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    People findByUsername(String username);
    People findByUserPass(String username, String password);
}
