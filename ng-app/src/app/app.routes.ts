import { Routes } from '@angular/router';
import { WeatherSearch } from './weather-search/weather-search';

export const routes: Routes = [
  { path: '', component: WeatherSearch, pathMatch: 'full' }
];
