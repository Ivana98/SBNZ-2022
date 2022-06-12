import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { CurrentUser } from 'src/app/model/currentUser';
import { ApiService } from '../api-services/api.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _getUserInfoUrl = "http://localhost:8080/user/returnCurrentUser";
  private _refresh_token_url = "http://localhost:8080/auth/refresh";

  private currentUser: CurrentUser = new CurrentUser(0, "", "", "", "");

  constructor(private _apiService: ApiService, private router: Router) { }
/*
  updateCurrentUser(name: string, surname: string){
    this.currentUser.name = name;
    this.currentUser.surname = surname;
  }
  */

  public getMyInfo() {
    return this._apiService.get(this._getUserInfoUrl)
      .pipe(map(user => {
        this.currentUser.userId = user.userId;
        this.currentUser.email = user.email;
        this.currentUser.name = user.name;
        this.currentUser.surname = user.surname;
        this.currentUser.userAuthority = user.userAuthority;
        return user;
      }));
  }
/*
  public getMyInfo() {
    this._apiService.get(this._getUserInfoUrl, this._apiService.headers)
    .pipe(map((res) => {
      console.log('Fetched user');
      this.currentUser = res;
    }));

    .subscribe(
      {
        next: data => {
          console.log(data);
          this.setupUser(data);
        },
        error: error => { console.log(error); }
      }
    );
  }*/

  setupUser(user) {
    console.log(user);

    this.currentUser = user;
    console.log(this.currentUser);

  }

  public getCurrentUser() {
    return this.currentUser
  }

  public getFullName(): string {
    return this.currentUser.name + " " + this.currentUser.surname;
  }

  public getAuthority(): string {
    return this.currentUser.userAuthority;
  }

}