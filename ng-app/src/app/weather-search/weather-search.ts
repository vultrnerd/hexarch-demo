import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Weather } from '../weather';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-weather-search',
  imports: [FormsModule, CommonModule],
  templateUrl: './weather-search.html',
  styleUrl: './weather-search.css'
})
export class WeatherSearch {
  private weatherService = inject(Weather);

  // Using Angular signals for reactive programming
  city = signal('');
  weatherData = signal<any>(null);
  error = signal<string | null>(null);
  loading = signal<boolean>(false);

  // Regular property for two-way binding
  cityInput: string = '';

  searchWeather() {
    this.city.set(this.cityInput);
    this.loading.set(true);
    this.error.set(null);

    this.weatherService.getWeather(this.city()).subscribe(
      data => {
        this.weatherData.set(data);
        this.loading.set(false);
      },
      error => {
        this.error.set('Could not retrieve weather data. Please try again.');
        this.loading.set(false);
        console.error(error);
      }
    );
  }
}
