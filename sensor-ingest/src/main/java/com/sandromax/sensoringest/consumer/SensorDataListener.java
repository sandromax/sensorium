package com.sandromax.sensoringest.consumer;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Component
public class SensorDataListener {
    @KafkaListener(topics = "sensor-data", groupId = "sensorium-ingest-group")
    public void consume(String message) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/sensors";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(message, headers);
        restTemplate.postForEntity(url, request, String.class);
    }
}
