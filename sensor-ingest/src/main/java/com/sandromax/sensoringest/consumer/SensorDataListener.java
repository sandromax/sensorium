package com.sandromax.sensoringest.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SensorDataListener {
    @KafkaListener(topics = "sensor-data", groupId = "sensorium-ingest-group")
    public void consume(String message) {
        System.out.println("🔥 Received sensor data: " + message);
    }
}
