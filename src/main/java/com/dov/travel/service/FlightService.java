package com.dov.travel.service;

import java.util.List;

import com.dov.travel.model.Flight;
import com.dov.travel.repository.FlightRepository;
import com.dov.travel.model.Flight;


public interface FlightService {
    public List<Flight> getAll();
    public void add(Flight flight);
    public void update(Flight flightParameter);
    public void delete(Long id);
    public Flight findById(Long id);
    //public List<StudentSubjectAverage> getStudentsAverageFlight();
}
