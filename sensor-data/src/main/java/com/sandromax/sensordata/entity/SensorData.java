package com.sandromax.sensordata.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sensor_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorId;
    private String type;
    private Double value;
    private Long timestamp;
}
