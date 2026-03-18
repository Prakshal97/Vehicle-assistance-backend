package com.breakdown.vehicle_assistance.repository;

import com.breakdown.vehicle_assistance.model.Mechanic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.geo.Distance;
import java.util.List;

public interface MechanicRepository extends MongoRepository<Mechanic, String> {

    List<Mechanic> findByLocationNear(GeoJsonPoint location, Distance distance);

}