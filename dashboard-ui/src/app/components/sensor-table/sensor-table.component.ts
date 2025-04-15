import { Component, OnInit } from '@angular/core';
import { SensorService, SensorData } from 'src/app/services/sensor.service';
import { CommonModule } from '@angular/common';
import { Subscription, interval } from 'rxjs';

@Component({
  selector: 'app-sensor-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sensor-table.component.html',
  styleUrls: ['./sensor-table.component.scss']
})
export class SensorTableComponent implements OnInit {
  sensors: SensorData[] = [];
  subscription!: Subscription;

  constructor(private sensorService: SensorService) {}

  ngOnInit(): void {
    this.loadData();

    this.subscription = interval(5000).subscribe(() => {
      this.loadData();
    });
  }

  loadData(): void {
    this.sensorService.getLatest().subscribe((data) => {
      this.sensors = data;
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
