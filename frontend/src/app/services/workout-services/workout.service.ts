import { HttpClient, HttpHeaders, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestMethod } from '../recommendation-service/recommendation.service';
import { catchError, filter, map } from 'rxjs/operators';
import { WorkoutDTO } from 'src/app/model/WorkoutDTO';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {

  endpoint = "http://localhost:8080/workout"

  headers = new HttpHeaders({
    Accept: 'application/json',
    'Content-Type': 'application/json'
  });

  constructor(public http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.get(this.endpoint);
  }

  getOne(id: string) {
    return this.get(`${this.endpoint}/${id}`);
  }

  insert(entity: WorkoutDTO): Observable<WorkoutDTO> {
    return this.post(`${this.endpoint}`, entity);
  }
  update(entity: WorkoutDTO): Observable<WorkoutDTO> {
    return this.put(`${this.endpoint}/${entity.id}`, entity);
  }
  deleteEntity(id: number): Observable<void> {
    return this.delete(`${this.endpoint}/${id}`);
  }


  private get(path: string, customHeaders?: HttpHeaders): Observable<any> {
    return this.request(path, null, RequestMethod.Get, customHeaders);
  }

  private post(path: string, body?: any, customHeaders?: HttpHeaders): Observable<any> {
    return this.request(path, body, RequestMethod.Post, customHeaders);
  }

  private put(path: string, body: any): Observable<any> {
    return this.request(path, body, RequestMethod.Put);
  }

  private delete(path: string, body?: any): Observable<any> {
    return this.request(path, body, RequestMethod.Delete);
  }

  private request(path: string, body: any, method = RequestMethod.Post, custemHeaders?: HttpHeaders): Observable<any> {
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
