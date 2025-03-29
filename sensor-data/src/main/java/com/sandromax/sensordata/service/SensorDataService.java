package com.sandromax.sensordata.service;

import com.sandromax.sensordata.entity.SensorData;
import com.sandromax.sensordata.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {
    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository) {
        this.repository = repository;
    }

    public SensorData save(SensorData data) {
        return repository.save(data);
    }
}
