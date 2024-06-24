package com.dov.travel.repository;
import java.util.List;

import com.dov.travel.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
