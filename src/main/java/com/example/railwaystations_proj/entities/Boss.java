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
@Table(name = "bosses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Boss {
    @Id
    @Column(name = "boss_id")
    private Integer Id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "phone_num")
    private String phone_num;


}
