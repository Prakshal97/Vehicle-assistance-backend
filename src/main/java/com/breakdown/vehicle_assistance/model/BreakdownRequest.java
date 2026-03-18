package com.breakdown.vehicle_assistance.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "breakdown_requests")
@Data
public class BreakdownRequest {

    @Id
    private String id;

    private String userId;
    private String vehicleType;
    private String problemDescription;

    private double latitude;
    private double longitude;

    private String status;
}