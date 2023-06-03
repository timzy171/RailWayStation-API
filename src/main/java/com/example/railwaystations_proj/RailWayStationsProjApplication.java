package com.example.railwaystations_proj;

import com.example.railwaystations_proj.controllers.RESTController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class RailWayStationsProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailWayStationsProjApplication.class, args);
    }

}
