export default class Product {

    private id: number;
    private name: string;
    private price: number;
    private stock: number;
    private description: string;
    // private category: Category;

    constructor (id: number, name: string, price: number, stock: number, description: string/*, category: Category*/) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public getId(): number {
        return this.id;
    }
    public setId(value: number) {
        this.id = value;
    }

    public getName(): string {
        return this.name;
    }
    public setName(value: string) {
        this.name = value;
    }

    public getPrice(): number {
        return this.price;
    }
    public setPrice(value: number) {
        this.price = value;
    }

    public getStock(): number {
        return this.stock;
    }
    public setStock(value: number) {
        this.stock = value;
    }

    public getDescription(): string {
        return this.description;
    }
    public setDescription(value: string) {
        this.description = value;
    }

    // public getCategory(): Category {
    //     return this.category;
    // }
    // public setCategory(value: Category) {
    //     this.category = value;
    // }
}