package com.sandromax.sensordata.controller;

import com.sandromax.sensordata.entity.SensorData;
import com.sandromax.sensordata.service.SensorDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/latest")
    public List<SensorData> getLatest() {
        return service.getLatestValues();
    }

    @GetMapping("/history")
    public List<SensorData> getHistory(
            @RequestParam String sensorId,
            @RequestParam(defaultValue = "24h") String period
    ) {
        return service.getHistory(sensorId, period);
    }
}
