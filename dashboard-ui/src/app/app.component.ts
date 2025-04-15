import { Component } from '@angular/core';
import { SensorChartComponent } from './components/sensor-chart/sensor-chart.component';
import { SensorTableComponent } from 'src/app/components/sensor-table/sensor-table.component';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [SensorChartComponent, SensorTableComponent],
    templateUrl: './app.component.html',
    styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'dashboard-ui';
}
