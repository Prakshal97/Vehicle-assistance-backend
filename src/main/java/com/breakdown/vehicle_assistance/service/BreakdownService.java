package com.breakdown.vehicle_assistance.service;

import com.breakdown.vehicle_assistance.model.BreakdownRequest;
import com.breakdown.vehicle_assistance.repository.BreakdownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreakdownService {

    @Autowired
    private BreakdownRepository breakdownRepository;

    public BreakdownRequest createRequest(BreakdownRequest request) {
        request.setStatus("PENDING");
        return breakdownRepository.save(request);
    }

    public List<BreakdownRequest> getRequestsByMechanic(String mechanicId) {
        return breakdownRepository.findByMechanicId(mechanicId);
    }

    public BreakdownRequest updateRequestStatus(String requestId, String status) {
        BreakdownRequest request = breakdownRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(status);
        return breakdownRepository.save(request);
    }
}