import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccessDeniedComponent } from './components/access-denied/access-denied.component';
import { AddWorkoutComponent } from './components/add-workout/add-workout.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { RegisterComponent } from './components/register/register.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { WorkoutRecommendationComponent } from './components/workout-recommendation/workout-recommendation.component';
import { WorkoutsComponent } from './components/workouts/workouts.component';
import { AdminGuard } from './guard/admin.guard';
import { UserGuard } from './guard/user.guard';

const routes: Routes = [
  { path: '', component: HomepageComponent, children: [
    { path: 'access-denied', component: AccessDeniedComponent},
    { path: 'sign-up', component: RegisterComponent},
    { path: 'sign-in', component: SignInComponent},
    { path: 'page-not-found', component: PageNotFoundComponent},
  ]},
  { path: 'dashboard', component: DashboardComponent, children: [
    { path: 'workout-recommendation', component: WorkoutRecommendationComponent},
    { path: 'workouts', component: WorkoutsComponent},
    { path: 'workouts/add-workout', component: AddWorkoutComponent},
  ]},
  { path: '**', redirectTo: '/page-not-found' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
