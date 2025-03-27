# 📦 Sensorium – MVP Backlog

IoT Dashboard for collecting, storing, and visualizing sensor data in real-time.

---

## 🔧 Infrastructure

### ✅ [USER STORY] Kafka Setup
**As a developer**, I want a local Kafka environment to test message flow.

- [ ] Set up `docker-compose` with Kafka + Zookeeper
- [ ] Create Kafka topic: `sensor-data`

### ✅ [USER STORY] Ingest Microservice
**As a developer**, I want a Spring Boot microservice to consume Kafka messages.

- [ ] Create `Ingest Service`
- [ ] Connect to Kafka and listen to `sensor-data`
- [ ] Log the incoming messages

---

## 🧪 Sensor Simulation

### ✅ [USER STORY] Sensor Emulator
**As a developer**, I want a script or microservice to simulate sensor data.

- [ ] Create `Sensor Emulator` (Java or Python)
- [ ] Emit random sensor values (temperature, humidity, etc.)
- [ ] Send events to Kafka topic

---

## 💾 Data Persistence

### ✅ [USER STORY] Data Storage
**As a data analyst**, I want to store sensor data in a database for querying.

- [ ] Create `Data Service`
- [ ] Use PostgreSQL or InfluxDB for storage
- [ ] Ingest → Data Service via REST or Kafka Stream

---

## 📡 API for Frontend

### ✅ [USER STORY] Latest Sensor Values
**As a user**, I want to see the latest readings from each sensor.

- [ ] Create REST endpoint: `/sensors/latest`
- [ ] Support filtering by sensor type

### ✅ [USER STORY] Sensor History
**As a frontend**, I want to fetch time-series data for graph rendering.

- [ ] Create REST endpoint: `/sensors/history?sensorId=X&period=24h`

---

## 📊 UI Dashboard

### ✅ [USER STORY] Live Dashboard
**As a user**, I want a dashboard to view real-time sensor data.

- [ ] Create Angular project `sensorium-dashboard`
- [ ] Display table of latest sensor values
- [ ] Render chart per sensor (Chart.js or ngx-charts)

---

## 📈 Monitoring

### ✅ [USER STORY] System Metrics in Grafana
**As a DevOps**, I want to monitor the data flow and system metrics.

- [ ] Connect Grafana to PostgreSQL (or Prometheus)
- [ ] Create dashboard: event rate, max/min/avg values

---

## ☁️ Cloud Integration

### ✅ [USER STORY] S3 Backup
**As a DevOps**, I want to store raw sensor messages in S3.

- [ ] Configure AWS SDK access
- [ ] Store raw JSON to S3 per message or in batches

---

### ✅ MVP Complete
Sensor → Kafka → Ingest → DB → API → UI + Grafana + S3
