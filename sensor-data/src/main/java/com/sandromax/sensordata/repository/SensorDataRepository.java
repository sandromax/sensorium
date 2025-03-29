package com.sandromax.sensordata.repository;

import com.sandromax.sensordata.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long>{
    @Query(value = """
    SELECT DISTINCT ON (sensor_id) *
    FROM sensor_data
    ORDER BY sensor_id, timestamp DESC
    """, nativeQuery = true)
    List<SensorData> findLatestForEachSensor();

    @Query("SELECT s FROM SensorData s WHERE s.sensorId = :sensorId AND s.timestamp >= :from ORDER BY s.timestamp")
    List<SensorData> findHistory(
            @Param("sensorId") String sensorId,
            @Param("from") Long fromTimestamp
    );

}
