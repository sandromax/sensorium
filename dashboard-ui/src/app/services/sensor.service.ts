import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface SensorData {
  sensorId: string;
  type: string;
  value: number;
  timestamp: number;
}

@Injectable({
  providedIn: 'root'
})
export class SensorService {
  private BASE_URL = 'http://localhost:8081/api/sensors';

  constructor(private http: HttpClient) {}

  getLatest(): Observable<SensorData[]> {
    return this.http.get<SensorData[]>(`${this.BASE_URL}/latest`);
  }

  getHistory(sensorId: string, period: string = '24h'): Observable<SensorData[]> {
    return this.http.get<SensorData[]>(`${this.BASE_URL}/history?sensorId=${sensorId}&period=${period}`);
  }
}

