import Product from "./Product";

export default class CartItem {

    private id: number;
    private cartId: number;
    private product: Product;
    private quantity: number;
    private dateCreated: Date;

    public constructor(id: number, cartId: number, product: Product, quantity: number, dateCreated: Date) {
        this.id = id;
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
        this.dateCreated = dateCreated;
    }

    public getId(): number {
        return this.id;
    }

    public setId(value: number) {
        this.id = value;
    }

    public getCartId(): number {
        return this.cartId;
    }

    public setCartId(value: number) {
        this.cartId = value;
    }

    public getProduct(): Product {
        return this.product;
    }

    public setProduct(value: Product) {
        this.product = value;
    }

    public getQuantity(): number {
        return this.quantity;
    }

    public setQuantity(value: number) {
        this.quantity = value;
    }

    public getDateCreated(): Date {
        return this.dateCreated;
    }

    public setDateCreated(value: Date) {
        this.dateCreated = value;
    }
}