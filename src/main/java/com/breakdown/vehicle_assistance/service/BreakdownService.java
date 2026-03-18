package com.breakdown.vehicle_assistance.service;

import com.breakdown.vehicle_assistance.model.BreakdownRequest;
import com.breakdown.vehicle_assistance.repository.BreakdownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreakdownService {

    @Autowired
    private BreakdownRepository breakdownRepository;

    public BreakdownRequest createRequest(BreakdownRequest request) {

        request.setStatus("PENDING");

        return breakdownRepository.save(request);
    }
}