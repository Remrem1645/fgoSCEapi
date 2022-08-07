package com.remsfgosim.rest.Repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.remsfgosim.rest.Models.CraftEssences;

public interface CraftEssencesRepo extends JpaRepository<CraftEssences, Long> {
    List<CraftEssences> findByRarity(int rarity);
    List<CraftEssences> findByType(String type);
}
