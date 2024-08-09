export default class User {
    private id: number;
    private firstname: string;
    private lastname: string;
    private username: string;
    private email: string;
    private password: string;
    private dateCreated: Date;
    private role: string;

    public constructor(
        id: number,
        firstname: string,
        lastname: string,
        username: string,
        email: string,
        password: string,
        dateCreated: Date,
        role: string) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
        this.role = role;
    }

    public getId(): number {
        return this.id;
    }

    public setId(value: number) {
        this.id = value;
    }

    public getFirstname(): string {
        return this.firstname;
    }

    public setFirstname(value: string) {
        this.firstname = value;
    }

    public getLastname(): string {
        return this.lastname;
    }

    public setLastname(value: string) {
        this.lastname = value;
    }

    public getUsername(): string {
        return this.username;
    }

    public setUsername(value: string) {
        this.username = value;
    }

    public getEmail(): string {
        return this.email;
    }

    public setEmail(value: string) {
        this.email = value;
    }

    public getPassword(): string {
        return this.password;
    }

    public setPassword(value: string) {
        this.password = value;
    }

    public getDateCreated(): Date {
        return this.dateCreated;
    }

    public setDateCreated(value: Date) {
        this.dateCreated = value;
    }

    public getRole(): string {
        return this.role;
    }

    public setRole(value: string) {
        this.role = value;
    }
}