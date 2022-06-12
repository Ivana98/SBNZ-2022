export class RegistrationRequest {
    constructor(
        public username: string,
        public password: string,
        public name: string,
        public surname: string,
        public bodyType: string,
        public activityLevel: string,
        public age: number,
        public height: number,
        public weight: number
    ) {} 
}