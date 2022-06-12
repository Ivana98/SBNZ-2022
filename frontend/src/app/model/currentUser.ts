export class CurrentUser {
    constructor(
        public userId: number,
        public email: string,
        public name: string,
        public surname: string,
        public userAuthority: string
    ) {} 
}