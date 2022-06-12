import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegistrationRequest } from 'src/app/model/registrationRequest';
import { RegisterService } from 'src/app/services/register-service/register.service';
import { mustMatchValidator } from 'src/app/shared/must-match.directive';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  myForm: FormGroup;

  submitted: boolean = false;
  errorMsg: string;
  successMsg: string;

  bodyTypes = [
    {value: 'ECTOMORPH', viewValue: 'Ectomorph'},
    {value: 'ENDOMORPH', viewValue: 'Endomorph'},
    {value: 'MESOMORPH', viewValue: 'Mesomorph'},
  ];

  activityLevels = [
    {value: 'INACTIVE', viewValue: 'Inactive - sedentary lifestyle/slightly active'},
    {value: 'LITTLE_ACTIVE', viewValue: 'Little active - Exercise 1-3 times a week'},
    {value: 'AVERAGE_ACTIVE', viewValue: 'Average active - Exercise 4-5 times a week'},
    {value: 'VERY_ACTIVE', viewValue: 'Very active - Exercise more than 5 times a week or do physical job'},
  ];

  constructor(
    private formBuilder: FormBuilder,
    private registerService: RegisterService
  ) {
    this.myForm = this.formBuilder.group({
      emailField: ["", [Validators.required, Validators.email]],
      nameField: ["", [Validators.required]],
      surnameField: ["", [Validators.required]],
      bodyTypeField: ["", [Validators.required]],
      activityLevelField: ["", [Validators.required]],
      ageField: ["", [Validators.required]],
      heightField: ["", [Validators.required]],
      weightField: ["", [Validators.required]],
      passwordField: ["", [Validators.required, Validators.minLength(3)]],
      confPasswordField: ["", [Validators.required, Validators.minLength(3)]]
    }, { validators: mustMatchValidator });
  }

  ngOnInit(): void {
  }

  sendRequest() : void {
    if (this.myForm.invalid) {
      return;
    }

    // hide form controls when user send request
    this.submitted = true;
    this.errorMsg = undefined;
    this.successMsg = undefined;

    let request = new RegistrationRequest(
      this.myForm.value['emailField'],
      this.myForm.value['passwordField'],
      this.myForm.value['nameField'],
      this.myForm.value['surnameField'],
      this.myForm.value['bodyTypeField'],
      this.myForm.value['activityLevelField'],
      this.myForm.value['ageField'],
      this.myForm.value['heightField'],
      this.myForm.value['weightField']
    );

    this.registerService.sendRegistrationRequest(request).subscribe({
      next: data => {
        this.successMsg = "You successfully send your registration request. You can sign in and start your workout now.";
      },
      error: error => {
        this.errorMsg = "This email address is already in use.";
      },
    });
  }

}
