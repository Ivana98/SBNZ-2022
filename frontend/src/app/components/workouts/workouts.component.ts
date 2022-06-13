import { AfterViewInit, Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { WorkoutDTO } from 'src/app/model/WorkoutDTO';
import { WorkoutService } from 'src/app/services/workout-services/workout.service';

@Component({
  selector: 'app-workouts',
  templateUrl: './workouts.component.html',
  styleUrls: ['./workouts.component.css']
})
export class WorkoutsComponent implements OnInit, AfterViewInit {

  selectedWorkoutId: number;

  prikazaneKolone: string[] = ['id', 'name', 'duration', 'workoutIntensity', 'workoutType', 'actions'];
  ELEMENT_DATA: WorkoutDTO[] = [];
  mojiPodaci = new MatTableDataSource<WorkoutDTO>(this.ELEMENT_DATA);

  constructor(private workoutService: WorkoutService, private router: Router) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    this.fetchData();

  }

  fetchData() {
    const promise = this.workoutService.getAll().toPromise();
    promise.then((data)=>{
      console.log(JSON.stringify(data));
      let jsonObj: any = JSON.parse(JSON.stringify(data));
      let response: WorkoutDTO[] = <WorkoutDTO[]>jsonObj;
      console.log(response);
      this.ELEMENT_DATA = response;
      this.mojiPodaci = new MatTableDataSource<WorkoutDTO>(response);
    }).catch((error)=>{
      console.log("Promise rejected with " + JSON.stringify(error));
    });
  }

  add() {
    this.router.navigate(['/dashboard/workouts/add-workout']);
  }

  update(workout: WorkoutDTO) {
    this.selectedWorkoutId = workout.id;
  }

  delete(workout: WorkoutDTO) {
    this.workoutService.deleteEntity(workout.id).subscribe();
    this.ELEMENT_DATA.forEach((x, index) => {
      if(x.id === workout.id) {
        this.ELEMENT_DATA.splice(index,1);
      }
    });
    this.mojiPodaci = new MatTableDataSource<WorkoutDTO>(this.ELEMENT_DATA);
  }

}
