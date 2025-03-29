package com.sandromax.sensordata.controller;

import com.sandromax.sensordata.entity.SensorData;
import com.sandromax.sensordata.service.SensorDataService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorDataController {
    private final SensorDataService service;

    public SensorDataController(SensorDataService service) {
        this.service = service;
    }

    @PostMapping
    public SensorData receiveSensorData(@RequestBody SensorData data) {
        return service.save(data);
    }
}
