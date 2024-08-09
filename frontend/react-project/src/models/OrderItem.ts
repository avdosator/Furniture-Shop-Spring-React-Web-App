import Product from "./Product";

export default class OrderItem {

    private id: number;
    private orderId: number;
    private quantity: number;
    private price: number;
    private product: Product;

    public constructor(id: number, orderId: number, quantity: number, price: number, product: Product) {
        this.id = id;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public getId(): number {
        return this.id;
    }

    public setId(value: number) {
        this.id = value;
    }

    public getOrderId(): number {
        return this.orderId;
    }

    public setOrderId(value: number) {
        this.orderId = value;
    }

    public getQuantity(): number {
        return this.quantity;
    }

    public setQuantity(value: number) {
        this.quantity = value;
    }

    public getPrice(): number {
        return this.price;
    }

    public setPrice(value: number) {
        this.price = value;
    }

    public getProduct(): Product {
        return this.product;
    }
    public setProduct(value: Product) {
        this.product = value;
    }
}