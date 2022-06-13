export class Recommendation {
    constructor(
        public maxDuration: number,
        public bodyType: string,
        public equipmentSet: string[],
        public activityLevel: string,
        public currentMood: string,
        public age: number,
        public height: number,
        public weight: number
    ) {} 
}