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
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private Integer id;

    @Column(name = "name")
    private String cityName;

    @Column(name = "district")
    private String district;

    @Column(name = "country")
    private String country;

}
