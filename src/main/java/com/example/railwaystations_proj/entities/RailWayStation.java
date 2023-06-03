package com.example.railwaystations_proj.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "railway_stations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RailWayStation {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Integer year;

    @Column(name = "employees")
    private Integer employees;

    @Column(name = "boss_id")
    private Integer boss_id;

    @Column(name = "city_id")
    private Integer city_id;
}
