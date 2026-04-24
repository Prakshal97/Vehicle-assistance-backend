package com.breakdown.vehicle_assistance.service;

import com.breakdown.vehicle_assistance.model.Mechanic;
import com.breakdown.vehicle_assistance.repository.MechanicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    // add mechanic (default to unapproved)
    public Mechanic addMechanic(Mechanic mechanic){
        mechanic.setApproved(false);
        return mechanicRepository.save(mechanic);
    }

    // get all mechanics (for admin)
    public List<Mechanic> getAllMechanics(){
        return mechanicRepository.findAll();
    }

    // get only approved mechanics (for users)
    public List<Mechanic> getApprovedMechanics(){
        return mechanicRepository.findAll().stream()
                .filter(Mechanic::isApproved)
                .collect(Collectors.toList());
    }

    // find nearby approved mechanics
    public List<Mechanic> findNearby(double lat, double lng) {
        GeoJsonPoint point = new GeoJsonPoint(lng, lat);
        Distance distance = new Distance(50, Metrics.KILOMETERS);

        return mechanicRepository.findByLocationNear(point, distance).stream()
                .filter(Mechanic::isApproved)
                .collect(Collectors.toList());
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

    // approve mechanic
    public Mechanic approveMechanic(String id) {
        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mechanic not found with id: " + id));
        mechanic.setApproved(true);
        return mechanicRepository.save(mechanic);
    }
    
}