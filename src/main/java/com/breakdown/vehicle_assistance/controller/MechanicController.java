package com.breakdown.vehicle_assistance.controller;

import com.breakdown.vehicle_assistance.model.Mechanic;
import com.breakdown.vehicle_assistance.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/mechanics")
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;

    @PostMapping("/add")
    public Mechanic addMechanic(@RequestBody Mechanic mechanic){
        return mechanicService.addMechanic(mechanic);
    }

    @GetMapping("/all")
    public List<Mechanic> getAllMechanics(){
        return mechanicService.getAllMechanics();
    }
    @GetMapping("/nearby")
public List<Mechanic> findNearby(@RequestParam double lat,
                                 @RequestParam double lng){

    return mechanicService.findNearby(lat,lng);
}

}
