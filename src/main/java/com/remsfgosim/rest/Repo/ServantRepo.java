package com.remsfgosim.rest.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.remsfgosim.rest.Models.Servants;

public interface ServantRepo extends JpaRepository<Servants, Long>{
    List<Servants> findByRarity(int rarity);
    List<Servants> findByType(String type);
}
