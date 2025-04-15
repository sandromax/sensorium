import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { SensorService, SensorData } from 'src/app/services/sensor.service';

@Component({
  selector: 'app-sensor-chart',
  standalone: true,
  imports: [CommonModule, NgxChartsModule],
  templateUrl: './sensor-chart.component.html',
  styleUrls: ['./sensor-chart.component.scss']
})
export class SensorChartComponent implements OnInit {
  sensorId = 'sensor-1';
  chartData: any[] = [];

  view: [number, number] = [700, 300];

  showXAxis = true;
  showYAxis = true;
  showLegend = false;
  showXAxisLabel = true;
  showYAxisLabel = true;
  xAxisLabel = 'Час';
  yAxisLabel = 'Значення';

  constructor(private sensorService: SensorService) {}

  ngOnInit(): void {
    this.sensorService.getHistory(this.sensorId, '6h').subscribe(data => {

      console.log('[SensorChart] Got data:', data);

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
}
