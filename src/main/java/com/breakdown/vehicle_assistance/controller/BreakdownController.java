package com.breakdown.vehicle_assistance.controller;

import com.breakdown.vehicle_assistance.model.BreakdownRequest;
import com.breakdown.vehicle_assistance.service.BreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/breakdown")
public class BreakdownController {

    @Autowired
    private BreakdownService breakdownService;

    @PostMapping("/request")
    public BreakdownRequest createRequest(@RequestBody BreakdownRequest request) {
        return breakdownService.createRequest(request);
    }
}