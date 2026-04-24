package com.breakdown.vehicle_assistance.controller;

import com.breakdown.vehicle_assistance.model.BreakdownRequest;
import com.breakdown.vehicle_assistance.service.BreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/breakdown")
public class BreakdownController {

    @Autowired
    private BreakdownService breakdownService;

    @PostMapping("/request")
    public BreakdownRequest createRequest(@RequestBody BreakdownRequest request) {
        return breakdownService.createRequest(request);
    }

    @GetMapping("/mechanic/{mechanicId}")
    public List<BreakdownRequest> getRequestsByMechanic(@PathVariable String mechanicId) {
        return breakdownService.getRequestsByMechanic(mechanicId);
    }

    @PutMapping("/{requestId}/status")
    public BreakdownRequest updateRequestStatus(@PathVariable String requestId, @RequestParam String status) {
        return breakdownService.updateRequestStatus(requestId, status);
    }
}