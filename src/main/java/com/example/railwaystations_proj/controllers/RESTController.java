package com.example.railwaystations_proj.controllers;

import com.example.railwaystations_proj.entities.Boss;
import com.example.railwaystations_proj.entities.City;
import com.example.railwaystations_proj.entities.RailWayStation;
import com.example.railwaystations_proj.exc_handling.NoSuchInfoException;
import com.example.railwaystations_proj.repositories.BossRepo;
import com.example.railwaystations_proj.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/railwayStations/{id}")
    private RailWayStation getRailWayStationById(@PathVariable Integer id){
        Optional<RailWayStation> station = railWayStationRepo.findById(id);
        if(station.isEmpty()){
            throw new NoSuchInfoException("There is no railwayStation with ID = " + id + "in database.");
        }
        return station.get();
    }


    @GetMapping("/cities/{id}")
    private City getCitiesById(@PathVariable Integer id){
        Optional<City> city = cityRepo.findById(id);
        if(city.isEmpty()){
            throw new NoSuchInfoException("There is no city with id = '" + id + "' in database.");
        }
        return city.get();
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

    @DeleteMapping("/cities/{id}")
    private String deleteCity(@PathVariable Integer id){
        Optional<City> city = cityRepo.findById(id);
        if(city.isEmpty()){
            throw new NoSuchInfoException("There is no city with id = '" + id + "' in database.");
        }

        cityRepo.delete(city.get());
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

    @PostMapping("/railwayStations")
    private RailWayStation addNewStation(@RequestBody RailWayStation station){
        railWayStationRepo.save(station);
        return station;
    }

    @PutMapping("/railwayStations")
    private RailWayStation editStation(@RequestBody RailWayStation station){
        railWayStationRepo.save(station);
        return station;
    }

    @DeleteMapping("/railwayStations/{stationName}")
    private String deleteStation(@PathVariable String stationName){
        RailWayStation station = railWayStationRepo.findAllByName(stationName);
        if(station == null){
            throw new NoSuchInfoException("There is no station with name = '" + stationName + "' in database.");
        }

        railWayStationRepo.delete(station);
        return "Success!";
    }

}
