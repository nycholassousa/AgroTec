package com.ufpb.repository;

import com.ufpb.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query("SELECT p FROM People p WHERE p.username = ?1")
    People findByUsername(String username);

    @Query("SELECT p FROM People p WHERE p.username = ?1 AND p.password = ?2")
    People findByUserPass(String username, String password);

    @Query("SELECT p FROM People p WHERE p.firstName = ?1")
    List<People> findByPeopleList(String firstname);
}
