import { WorkoutDTO } from "./WorkoutDTO";

export interface RecommendationResponse {
    advice: string;
    recommendedWorkouts: WorkoutDTO[];
}