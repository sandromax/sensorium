package com.sandromax.sensordata.repository;

import com.sandromax.sensordata.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepository extends JpaRepository<SensorData, Long>{
}
