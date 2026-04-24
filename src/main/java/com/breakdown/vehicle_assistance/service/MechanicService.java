package com.breakdown.vehicle_assistance.service;

import com.breakdown.vehicle_assistance.model.Mechanic;
import com.breakdown.vehicle_assistance.repository.MechanicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;

import java.util.List;

@Service
public class MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    // add mechanic
    public Mechanic addMechanic(Mechanic mechanic){
        return mechanicRepository.save(mechanic);
    }

    // get all mechanics
    public List<Mechanic> getAllMechanics(){
        return mechanicRepository.findAll();
    }

    // find nearby mechanics
    public List<Mechanic> findNearby(double lat, double lng) {

        GeoJsonPoint point = new GeoJsonPoint(lng, lat);
        Distance distance = new Distance(50, Metrics.KILOMETERS);

        return mechanicRepository.findByLocationNear(point, distance);
    }

    // update mechanic
    public Mechanic updateMechanic(String id, Mechanic mechanicDetails) {
        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mechanic not found with id: " + id));
        
        mechanic.setName(mechanicDetails.getName());
        mechanic.setPhone(mechanicDetails.getPhone());
        mechanic.setServiceType(mechanicDetails.getServiceType());
        if (mechanicDetails.getLocation() != null) {
            mechanic.setLocation(mechanicDetails.getLocation());
        }
        
        return mechanicRepository.save(mechanic);
    }

    // delete mechanic
    public void deleteMechanic(String id) {
        mechanicRepository.deleteById(id);
    }
    
}