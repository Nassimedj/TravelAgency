package com.dov.travel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dov.travel.model.Flight;
import com.dov.travel.model.City;
import com.dov.travel.model.Airplane;
import com.dov.travel.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public void add(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void update(Flight flightParameter) {
        if (findById(flightParameter.getFlightNumber()) != null) {
            flightRepository.save(flightParameter);
        }
    }

    @Override
    public void delete(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Flight findById(Long id) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent()) {
            return optionalFlight.get();
        }
        return null;
    }

    /*@Override
    public List<StudentSubjectAverage> getStudentsAverageFlight() {
        List<Object[]> results = flightRepository.calculateStudentSubjectAverages();
        return results.stream()
                .map(result -> {
                    String firstName = ((Student) result[0]).getFirstName();
                    String lastName = ((Student) result[0]).getLastName();
                    String subjectName = ((Subject) result[1]).getName();
                    Double average = (Double) result[2];
                    return new StudentSubjectAverage(firstName, lastName, subjectName, average);
                })
                .collect(Collectors.toList());
    }*/

}
