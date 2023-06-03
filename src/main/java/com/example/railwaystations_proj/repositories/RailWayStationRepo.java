package com.example.railwaystations_proj.repositories;

import com.example.railwaystations_proj.entities.RailWayStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RailWayStationRepo extends JpaRepository<RailWayStation, Integer> {
    RailWayStation findAllByName(String name);
}
