package com.example.railwaystations_proj.repositories;

import com.example.railwaystations_proj.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {
    City findByCityName(String toString);
}
