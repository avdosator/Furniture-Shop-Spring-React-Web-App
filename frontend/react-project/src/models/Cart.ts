import User from "./User";

export default class Cart {

    private id: number;
    private user: User;
    // private cartItems: CartItem[];
    private dateCreated: Date;

    public constructor(id: number, user: User, /*cartItems: CartItem []*/ dateCreated: Date) {
        this.id = id;
        this.user = user;
        // this.cartItems = cartItems;
        this.dateCreated = dateCreated;
    }
    
    public getId(): number {
        return this.id;
    }

    public setId(value: number) {
        this.id = value;
    }

    public getUser(): User {
        return this.user;
    }

    public setUser(value: User) {
        this.user = value;
    }

    // public getCartItems(): CartItem[] {
    //     return this.cartItems;
    // }
    // public setCartItems(value: CartItem[]) {
    //     this.cartItems = value;
    // }

    public getDateCreated(): Date {
        return this.dateCreated;
    }

    public setDateCreated(value: Date) {
        this.dateCreated = value;
    }
}