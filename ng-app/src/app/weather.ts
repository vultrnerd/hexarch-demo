import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Weather {
  private http = inject(HttpClient);
  private backendUrl = '/api/weather'; // Backend REST endpoint via proxy

  getWeather(city: string): Observable<any> {
    const url = `${this.backendUrl}/${city}`;
    console.log(`Fetching data from: ${url}`);
    return this.http.get(url);
  }
}
