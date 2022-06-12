import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from '../api-services/api.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private _ulrSendRequest: string = "http://localhost:8080/auth/registerRequest";

  constructor(private _apiService: ApiService) { }

  sendRegistrationRequest(request)
  {
    return this._apiService.post(this._ulrSendRequest, request, this._apiService.headers);
  }
}
