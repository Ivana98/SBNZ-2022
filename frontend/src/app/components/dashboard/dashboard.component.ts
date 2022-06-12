import { AfterViewInit, Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { LoginService } from 'src/app/services/login-service/login.service';
import { RecommendationService } from 'src/app/services/recommendation-service/recommendation.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  name: string;
  authority: string;

  constructor(
    private loginService: LoginService,
    private recommendationS: RecommendationService,
    private authService: AuthService
    ) { }

  ngOnInit(): void {
    this.name = this.loginService.getFullName();
    this.authority = this.loginService.getAuthority();
  }

  signout() {
    this.authService.logout();
  }

  req() {
    let recomm = {
      "maxDuration": 45.0,
      "bodyType": "ENDOMORPH",
      "equipmentSet": ["EXPANDER", "DUMBBELLS"],
      "activityLevel": "VERY_ACTIVE",
      "currentMood": "NORMAL",
      "age": 22,
      "height": 1.64,
      "weight": 65
  }
    this.recommendationS.getWorkoutRecommendation(recomm).subscribe({
      next: data => {console.log(data)},
      error: error => {console.log(error);}
    });
  }

}
