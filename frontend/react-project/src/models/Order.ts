import OrderItem from "./OrderItem";
import User from "./User";

export default class Order {

    private id: number;
    private user: User;
    private orderItems: OrderItem[];
    private totalAmount: number;
    private orderStatus: string;
    private dateCreated: Date;

    public constructor(id: number, user: User, orderItems: OrderItem[], totalAmount: number, orderStatus: string, dateCreated: Date) {
        this.id = id;
        this.user = user;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
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

    public getOrderItems(): OrderItem[] {
        return this.orderItems;
    }
    public setOrderItems(value: OrderItem[]) {
        this.orderItems = value;
    }

    public getTotalAmount(): number {
        return this.totalAmount;
    }
    public setTotalAmount(value: number) {
        this.totalAmount = value;
    }

    public getOrderStatus(): string {
        return this.orderStatus;
    }
    public setOrderStatus(value: string) {
        this.orderStatus = value;
    }

    public getDateCreated(): Date {
        return this.dateCreated;
    }
    public setDateCreated(value: Date) {
        this.dateCreated = value;
    }
}