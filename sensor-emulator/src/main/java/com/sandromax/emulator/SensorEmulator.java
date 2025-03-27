package com.sandromax.emulator;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class SensorEmulator {

    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String TOPIC = "sensor-data";
    private static final Random random = new Random();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        while (true) {
            Map<String, Object> sensorData = new HashMap<>();
            sensorData.put("sensorId", "sensor-" + (random.nextInt(5) + 1));
            sensorData.put("type", "temperature");
            sensorData.put("value", 20 + random.nextDouble() * 15); // 20-35°C
            sensorData.put("timestamp", System.currentTimeMillis());

            String json = mapper.writeValueAsString(sensorData);
            producer.send(new ProducerRecord<>(TOPIC, json));

            System.out.println("Sent: " + json);
            Thread.sleep(1000); // 1 message per second
        }
    }
}
