package com.breakdown.vehicle_assistance.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Document(collection = "mechanics")
@Data
public class Mechanic {

    @Id
    private String id;

    private String name;
    private String phone;

    private GeoJsonPoint location;

    private String serviceType;
}