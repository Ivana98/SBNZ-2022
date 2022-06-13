import { HttpClient, HttpHeaders, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiService } from '../api-services/api.service';
import { catchError, filter, map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { WorkoutDTO } from 'src/app/model/WorkoutDTO';
import { RecommendationResponse } from 'src/app/model/recommendationResponse';
import { LoginService } from '../login-service/login.service';

export enum RequestMethod {
  Get = 'GET',
  Head = 'HEAD',
  Post = 'POST',
  Put = 'PUT',
  Delete = 'DELETE',
  Options = 'OPTIONS',
  Patch = 'PATCH'
}

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {

  private _ulrSendRequest: string = "http://localhost:8080/recommendation";

  constructor(private _apiService: ApiService, private http: HttpClient, private loginService: LoginService) { }

  headers = new HttpHeaders({
    Accept: 'application/json',
    'Content-Type': 'application/json'
  });


  getWorkoutRecommendation(request): Observable<RecommendationResponse> {
    return this.put(this._ulrSendRequest, request);
  }

  getUserInfo(): Observable<any> {
    let id = this.loginService.getUserId();
    return this.get("http://localhost:8080/exerciser/"+id);
  }


put(path: string, body: any): Observable<any> {
  return this.request(path, body, RequestMethod.Put);
}

get(path: string, customHeaders?: HttpHeaders): Observable<any> {
  return this.request(path, null, RequestMethod.Get, customHeaders);
}

request(path: string, body: any, method = RequestMethod.Post, custemHeaders?: HttpHeaders): Observable<any> {
  const req = new HttpRequest(method, path, body, {
    headers: custemHeaders || this.headers,
  });

  return this.http.request(req)
    .pipe(filter(response => response instanceof HttpResponse))
    .pipe(map((response: HttpResponse<any>) => response.body))
    .pipe(catchError(error => this.checkError(error)));
}


// Display error if logged in, otherwise redirect to IDP
private checkError(error: any): any {
  if (error && error.status === 401) {
    // this.redirectIfUnauth(error);
  } else {
    // this.displayError(error);
  }
  throw error;
}

}
