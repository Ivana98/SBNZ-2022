import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { WorkoutDTO } from 'src/app/model/WorkoutDTO';
import { WorkoutService } from 'src/app/services/workout-services/workout.service';

@Component({
  selector: 'app-add-workout',
  templateUrl: './add-workout.component.html',
  styleUrls: ['./add-workout.component.css']
})
export class AddWorkoutComponent implements OnInit {

  workoutIntensity = [
    {value: 'LOW', viewValue: 'Low'},
    {value: 'MEDIUM', viewValue: 'Medium'},
    {value: 'HIGH', viewValue: 'High'},
  ];

  workoutType = [
    {value: 'CARDIO', viewValue: 'Cardio'},
    {value: 'STRENGTH', viewValue: 'Strength'}
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

  //@Input() myParentData = "";  //workout id
  myForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private workoutService: WorkoutService, private router: Router
    ) {
      this.myForm = this.formBuilder.group({
        durationField: ["", [Validators.required]],
        nameField: ["", [Validators.required]],
        linkField: ["", [Validators.required]],
        equipmentField0: [false],
        equipmentField1: [false],
        equipmentField2: [false],
        workoutIntensityField: ["", [Validators.required]],
        workoutTypeField: ["", [Validators.required]],
        moodField0: [false],
        moodField1: [false],
        moodField2: [false],
        moodField3: [false],
        moodField4: [false],
        moodField5: [false],
        moodField6: [false],
      });
    }

  ngOnInit(): void {
  }

  sendRequest() {
    if (this.myForm.invalid) {
      return;
    }

    let dto: WorkoutDTO = {
      duration: parseFloat(this.myForm.value['durationField']),
      name: this.myForm.value['nameField'],
      link: this.myForm.value['linkField'],
      equipmentSet: this.getCheckedEquipment(),
      workoutIntensity: this.myForm.value['workoutIntensityField'],
      workoutType: this.myForm.value['workoutTypeField'],
      moodSet: this.getCheckedMood()
    }

    this.workoutService.insert(dto).subscribe();
    this.router.navigate(['/dashboard/workouts']);

  }

  private getCheckedEquipment(): string[] {
    let choosenItems=[];
    if(this.myForm.value['equipmentField0']) {choosenItems.push(this.equipmentSet[0].value);}
    if(this.myForm.value['equipmentField1']) {choosenItems.push(this.equipmentSet[1].value);}
    if(this.myForm.value['equipmentField2']) {choosenItems.push(this.equipmentSet[2].value);}
    return choosenItems;
  }

  private getCheckedMood(): string[] {
    let choosenItems=[];
    if(this.myForm.value['moodField0']) {choosenItems.push(this.moodSet[0].value);}
    if(this.myForm.value['moodField1']) {choosenItems.push(this.moodSet[1].value);}
    if(this.myForm.value['moodField2']) {choosenItems.push(this.moodSet[2].value);}
    if(this.myForm.value['moodField3']) {choosenItems.push(this.moodSet[3].value);}
    if(this.myForm.value['moodField4']) {choosenItems.push(this.moodSet[4].value);}
    if(this.myForm.value['moodField5']) {choosenItems.push(this.moodSet[5].value);}
    if(this.myForm.value['moodField6']) {choosenItems.push(this.moodSet[6].value);}
    return choosenItems;
  }

}
