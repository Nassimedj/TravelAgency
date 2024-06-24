package com.dov.travel.service;

import java.util.List;

import com.dov.travel.model.Airplane;

public interface AirplaneService {
    public List<Airplane> getAll();
    public void add(Airplane airplane);
    public void update(Airplane airplane);
    public void delete(Long id);
    public Airplane findById(Long id);
}
