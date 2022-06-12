import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserLogin } from 'src/app/model/userLogin';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { LoginService } from 'src/app/services/login-service/login.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  myForm: FormGroup;
  submitted = false;
  errorMsg : string;

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private authService: AuthService,
    private router: Router
  ) {
    this.myForm = this.formBuilder.group({
      emailField: ["", [Validators.required, Validators.email]],
      passwordField: ["", Validators.required]
    });
  }

  ngOnInit(): void {
  }

  sendRequest() : void {
    if (this.myForm.invalid) {
      return;
    }

    let user = new UserLogin(
      this.myForm.value['passwordField'],
      this.myForm.value['emailField']
    );

    this.authService.login(user)
      .subscribe(
        {
          next: data => {
            this.loginService.getMyInfo()
            .subscribe(
              {
                next: data => {
                  this.router.navigate(['/dashboard']);
                },
                error: error => {}
              }
            );
          },
          error: error => {
            this.submitted = false;
            this.errorMsg = 'Incorrect username or password.';
          }
        }
      );
  }

}
