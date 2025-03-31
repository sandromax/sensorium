import { Component, OnInit } from '@angular/core';
import { SensorService, SensorData } from 'src/app/services/sensor.service';

@Component({
  selector: 'app-sensor-table',
  templateUrl: './sensor-table.component.html'
})
export class SensorTableComponent implements OnInit {
  sensors: SensorData[] = [];

  constructor(private sensorService: SensorService) {}

  ngOnInit() {
    this.sensorService.getLatest().subscribe(data => {
      this.sensors = data;
    });
  }
}
