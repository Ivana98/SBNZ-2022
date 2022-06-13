import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Recommendation } from 'src/app/model/recommendation';
import { RecommendationResponse } from 'src/app/model/recommendationResponse';
import { WorkoutDTO } from 'src/app/model/WorkoutDTO';
import { RecommendationService } from 'src/app/services/recommendation-service/recommendation.service';


@Component({
  selector: 'app-workout-recommendation',
  templateUrl: './workout-recommendation.component.html',
  styleUrls: ['./workout-recommendation.component.css']
})
export class WorkoutRecommendationComponent implements OnInit {

  myForm: FormGroup;
  gotResponse = false;
  workoutList = [];
  advice = "";
  userInfo;

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

  equipmentSet = [
    {value: 'EXPANDER', viewValue: 'Expander', checked: false},
    {value: 'RESISTANT_BAND', viewValue: 'Resistant band', checked: false},
    {value: 'DUMBBELLS', viewValue: 'Dumbbells', checked: false},
  ];

  moodSet = [
    {value: 'STRESSED_ANXIOUS', viewValue: 'Stressed/anxious'},
    {value: 'EXHAUSTED', viewValue: 'Exhausted'},
    {value: 'ANGRY_MOROSE', viewValue: 'Angry/morose'},
    {value: 'BLUE', viewValue: 'Blue'},
    {value: 'BORED', viewValue: 'Bored'},
    {value: 'GOOD_HAPPY', viewValue: 'Good/happy'},
    {value: 'NORMAL', viewValue: 'Normal'}
  ];

  constructor(
    private formBuilder: FormBuilder,
    private recommendationService: RecommendationService
  ) {
    this.myForm = this.formBuilder.group({
      maxDurationField: ["", [Validators.required]],
      bodyTypeField: ["", [Validators.required]],
      equipmentField0: [false],
      equipmentField1: [false],
      equipmentField2: [false],
      activityLevelField: ["", [Validators.required]],
      currentMoodField: ["", [Validators.required]],
      ageField: ["", [Validators.required]],
      heightField: ["", [Validators.required]],
      weightField: ["", [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.recommendationService.getUserInfo().subscribe(
      {
        next: data => {
          this.userInfo = data;
          this.updateMyForm();
        }
      }
    );
  }

  updateMyForm() {
    this.myForm.patchValue({
      ageField: this.userInfo.age,
      heightField: this.userInfo.height,
      weightField: this.userInfo.weight,
      bodyTypeField: this.userInfo.bodyType,
      activityLevelField: this.userInfo.activityLevel
    });
  }

  sendRequest() : void {
    if (this.myForm.invalid) {
      return;
    }

    let dto = new Recommendation(
      parseFloat(this.myForm.value['maxDurationField']),
      this.myForm.value['bodyTypeField'],
      this.getCheckedEquipment(),
      this.myForm.value['activityLevelField'],
      this.myForm.value['currentMoodField'],
      parseInt(this.myForm.value['ageField']),
      parseFloat(this.myForm.value['heightField']),
      parseFloat(this.myForm.value['weightField'])
    );

    const promise = this.recommendationService.getWorkoutRecommendation(dto).toPromise();
    console.log(promise);
    promise.then((data)=>{
      let list = JSON.stringify(data)
      console.log(JSON.stringify(data));
      let jsonObj: any = JSON.parse(JSON.stringify(data)); // string to generic object first
      let response: RecommendationResponse = <RecommendationResponse>jsonObj;
      console.log(response.advice);
      console.log(response.recommendedWorkouts);
      this.gotResponse = true;
      this.advice = response.advice;
      this.workoutList = response.recommendedWorkouts;

    }).catch((error)=>{
      console.log("Promise rejected with " + JSON.stringify(error));
    });
  }

  private getCheckedEquipment(): string[] {
    let choosenItems=[];
    if(this.myForm.value['equipmentField0']) {choosenItems.push(this.equipmentSet[0].value);}
    if(this.myForm.value['equipmentField1']) {choosenItems.push(this.equipmentSet[1].value);}
    if(this.myForm.value['equipmentField2']) {choosenItems.push(this.equipmentSet[2].value);}
    return choosenItems;
  }

/*
  public wList = [
    {
      duration: 45,
equipmentSet: ['EXPANDER', 'DUMBBELLS'],
id: 5,
link: "https://www.youtube.com/embed/nM1ZIgMhy_4",
moodSet: ['BORED', 'GOOD_HAPPY', 'NORMAL'],
name: "Cardio 5",
workoutIntensity: "HIGH",
workoutType: "CARDIO",
    },
    {
      duration: 45,
equipmentSet: ['EXPANDER'],
id: 7,
link: "https://www.youtube.com/embed/nM1ZIgMhy_4",
moodSet: ['BORED', 'GOOD_HAPPY', 'NORMAL'],
name: "Cardio 7",
workoutIntensity: "HIGH",
workoutType: "CARDIO",
    }
  ]*/

}
