package com.example.railwaystations_proj.controllers;

import com.example.railwaystations_proj.entities.Boss;
import com.example.railwaystations_proj.entities.City;
import com.example.railwaystations_proj.entities.RailWayStation;
import com.example.railwaystations_proj.exc_handling.NoSuchInfoException;
import com.example.railwaystations_proj.repositories.BossRepo;
import com.example.railwaystations_proj.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;
import com.example.railwaystations_proj.repositories.RailWayStationRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    RailWayStationRepo railWayStationRepo;

    @Autowired
    BossRepo bossRepo;

    @Autowired
    CityRepo cityRepo;


    @GetMapping("/railwayStations")
    private List<RailWayStation> showAllRailWayStation(){
        return railWayStationRepo.findAll();
    }

    @GetMapping("/bosses")
    private List<Boss> showAllBosses(){
        return bossRepo.findAll();
    }

    @GetMapping("/cities")
    private List<City> showAllCities(){
        return cityRepo.findAll();
    }

    @GetMapping("/railwayStations/{name}")
    private RailWayStation getRailWayStationByName(@PathVariable String name){
        StringBuilder stringBuilder = new StringBuilder(name);
        char ch = name.charAt(0);
        stringBuilder.setCharAt(0,Character.toUpperCase(ch));
        RailWayStation station = railWayStationRepo.findAllByName(stringBuilder.toString());

        if(station == null){
            throw new NoSuchInfoException("There is no railwayStation with ID = " + name + "in database.");
        }

        return station;
    }


    @GetMapping("/cities/{cityName}")
    private City getCitiesByName(@PathVariable String cityName){
        StringBuilder stringBuilder = new StringBuilder(cityName);
        char ch = cityName.charAt(0);
        stringBuilder.setCharAt(0,Character.toUpperCase(ch));
        City city = cityRepo.findByCityName(stringBuilder.toString());

        if(city == null){
            throw new NoSuchInfoException("There is no city with cityName = '" + cityName + "' in database.");
        }

        return city;
    }

    @GetMapping("/bosses/{id}")
    private Boss getBossById(@PathVariable int id){
        Boss boss = bossRepo.findById(id);
        if(boss == null){
            throw new NoSuchInfoException("There is no boss with ID = " + id + " in database.");
        }
        return boss;
    }

    @PostMapping("/cities")
    private City addNewCity(@RequestBody City city){
        cityRepo.save(city);
        return city;
    }

    @PutMapping("/cities")
    private City editCity(@RequestBody City city){
        cityRepo.save(city);
        return city;
    }

    @DeleteMapping("/cities/{cityName}")
    private String deleteCity(@PathVariable String cityName){
        City city = cityRepo.findByCityName(cityName);
        if(city == null){
            throw new NoSuchInfoException("There is no city with cityName = '" + cityName + "' in database.");
        }

        cityRepo.delete(city);
        return "Success!";
    }

    @PostMapping("/bosses")
    private Boss addNewBoss(@RequestBody Boss boss){
        bossRepo.save(boss);
        return boss;
    }

    @PutMapping("/bosses")
    private Boss editBoss(@RequestBody Boss boss){
        bossRepo.save(boss);
        return boss;
    }

    @DeleteMapping("/bosses/{id}")
    private String deleteBoss(@PathVariable Integer id){
        Optional<Boss> boss = bossRepo.findById(id);
        if(boss.isEmpty()){
            throw new NoSuchInfoException("There is no boss with id = '" + id + "' in database.");
        }

        bossRepo.delete(boss.get());
        return "Success!";
    }
}
