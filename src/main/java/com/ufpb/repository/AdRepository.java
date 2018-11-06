package com.ufpb.repository;

import com.ufpb.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad,Long> {
    @Query("SELECT a FROM Ad a WHERE a.regiao = ?1")
    List<Ad> findAdByRegiao(String regiao);
}
