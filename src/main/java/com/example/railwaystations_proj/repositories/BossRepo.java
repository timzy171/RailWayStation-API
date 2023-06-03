package com.example.railwaystations_proj.repositories;

import com.example.railwaystations_proj.entities.Boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepo extends JpaRepository<Boss, Integer> {
    Boss findById(int id);
}
