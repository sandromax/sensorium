package com.sandromax.sensordata.service;

import com.sandromax.sensordata.entity.SensorData;
import com.sandromax.sensordata.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataService {
    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository) {
        this.repository = repository;
    }

    public SensorData save(SensorData data) {
        return repository.save(data);
    }

    public List<SensorData> getLatestValues() {
        return repository.findLatestForEachSensor();
    }

    public List<SensorData> getHistory(String sensorId, String period) {
        long now = System.currentTimeMillis();
        long periodMs = parsePeriod(period);
        long from = now - periodMs;
        return repository.findHistory(sensorId, from);
    }

    private long parsePeriod(String period) {
        if (period.endsWith("h")) {
            int hours = Integer.parseInt(period.replace("h", ""));
            return hours * 60L * 60L * 1000L;
        } else if (period.endsWith("d")) {
            int days = Integer.parseInt(period.replace("d", ""));
            return days * 24L * 60L * 60L * 1000L;
        }
        throw new IllegalArgumentException("Unsupported period format: " + period);
    }
}
