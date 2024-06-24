package com.dov.travel.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dov.travel.model.Flight;
import com.dov.travel.service.AirplaneService;
import com.dov.travel.service.FlightService;
import com.dov.travel.service.CityService;

@Controller
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("flights", flightService.getAll());
        return "flight/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Flight flight, Model model) {
        model.addAttribute("citys", cityService.getAll());
        model.addAttribute("airplanes", airplaneService.getAll());
        return "flight/add";
    }

    @PostMapping("/add")
    public String processAdd(@Valid Flight flight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/flight/add";
        }
        flightService.add(flight);
        return "redirect:/flight/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("citys", cityService.getAll());
        model.addAttribute("airplanes", airplaneService.getAll());
        Flight flight = flightService.findById(id);
        model.addAttribute("flight", flight);
        return "flight/update";
    }

    @PostMapping("/update")
    public String processUpdate(Flight flight) {
        flightService.update(flight);
        return "redirect:/flight/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        flightService.delete(id);
        return "redirect:/flight/list";
    }

    /*@GetMapping("/average")
    public String average(Model model) {
        model.addAttribute("airplaneCityAverages", flightService.getAirplanesAverageFlight());
        return "flight/average";
    }*/

}
