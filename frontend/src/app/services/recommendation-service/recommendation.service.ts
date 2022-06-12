import { Injectable } from '@angular/core';
import { ApiService } from '../api-services/api.service';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {

  private _ulrSendRequest: string = "http://localhost:8080/recommendation";

  constructor(private _apiService: ApiService) { }

  getWorkoutRecommendation(request) {
    return this._apiService.put(this._ulrSendRequest, request);
  }

}
