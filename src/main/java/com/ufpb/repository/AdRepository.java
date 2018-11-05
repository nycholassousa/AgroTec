package com.ufpb.repository;

import com.ufpb.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad,Long> {
    @Query("SELECT a FROM Ad a WHERE a.id = ?1")
    Ad findAdById(Long id);
}
