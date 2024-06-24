package com.dov.travel.repository;
import com.dov.travel.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository  extends JpaRepository<Airplane, Long> {

}
