package com.breakdown.vehicle_assistance.repository;

import com.breakdown.vehicle_assistance.model.BreakdownRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BreakdownRepository extends MongoRepository<BreakdownRequest, String> {
    List<BreakdownRequest> findByMechanicId(String mechanicId);
}
