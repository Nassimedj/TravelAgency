package com.dov.travel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;


@Entity
@Data
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightNumber;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "departure_city_id")
    private City depCity;

    @ManyToOne
    @JoinColumn(name = "arrival_city_id")
    private City arr_city;


    @Column(name = "departure_time")
    private Date departure_time;

    @Column(name = "arrival_time")
    private Date arrival_time;

}
