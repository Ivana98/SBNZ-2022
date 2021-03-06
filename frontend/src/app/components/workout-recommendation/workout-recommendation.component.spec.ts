import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkoutRecommendationComponent } from './workout-recommendation.component';

describe('WorkoutRecommendationComponent', () => {
  let component: WorkoutRecommendationComponent;
  let fixture: ComponentFixture<WorkoutRecommendationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorkoutRecommendationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkoutRecommendationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
