import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { SensorService, SensorData } from 'src/app/services/sensor.service';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-sensor-chart',
  standalone: true,
  imports: [CommonModule, NgxChartsModule],
  templateUrl: './sensor-chart.component.html',
  styleUrls: ['./sensor-chart.component.scss']
})
export class SensorChartComponent implements OnInit {
  sensorId = 'sensor-1';
  availableSensors = ['sensor-1', 'sensor-2', 'sensor-3', 'sensor-4', 'sensor-5'];
  chartData: any[] = [];
  subscription!: Subscription;
  view: [number, number] = [700, 300];

  showXAxis = true;
  showYAxis = true;
  showLegend = false;
  showXAxisLabel = true;
  showYAxisLabel = true;
  xAxisLabel = 'Time';
  yAxisLabel = 'Value';

  constructor(private sensorService: SensorService) {}

  ngOnInit(): void {
    this.loadChart();

    this.subscription = interval(5000).subscribe(() => {
      this.loadChart();
    });
  }

  onSensorChange(event: Event) {
    this.sensorId = (event.target as HTMLSelectElement).value;
    this.loadChart();
  }

  loadChart(): void {
    this.sensorService.getHistory(this.sensorId, '6h').subscribe(data => {
      this.chartData = [
        {
          name: this.sensorId,
          series: data
            .filter(d => !isNaN(d.value))
            .map(d => ({
              name: new Date(d.timestamp).toLocaleTimeString(),
              value: d.value
            }))
        }
      ];
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
