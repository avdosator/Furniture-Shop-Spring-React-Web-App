import Category from "../../models/Category";
import Product from "../../models/Product";
import ProductItem from "./ProductItem";
import SearchProductsForm from "./SearchProductsForm";

export default function ProductsList() {

    let products: Product[] = [];
    products.push(new Product(1, "iron chair", 50.0, 1, "The best chair", new Category(1, "chair")));
    products.push(new Product(2, "wooden table", 195.0, 1, "Top quality", new Category(1, "bed")));
    products.push(new Product(3, "double bed", 995.0, 1, "Top quality", new Category(1, "bed")));
    products.push(new Product(4, "kitchen", 3500.0, 1, "Top quality", new Category(1, "kitchen")));
    products.push(new Product(5, "sofa", 355.0, 1, "Top quality", new Category(1, "sofa")));
    products.push(new Product(6, "table", 250.0, 1, "Top quality", new Category(1, "table")));
    products.push(new Product(7, "chair", 45.0, 1, "Top quality", new Category(1, "chair")));
    products.push(new Product(8, "closet", 1500.0, 1, "Top quality", new Category(1, "closet")));
    products.push(new Product(9, "big mirror", 150.0, 1, "Top quality", new Category(1, "accessories")));
    products.push(new Product(10, "gaming table", 300.0, 1, "Top quality", new Category(1, "table")));
    products.push(new Product(11, "gaming chair", 250.0, 1, "Top quality", new Category(1, "chair")));
    products.push(new Product(12, "shelves", 199.0, 1, "Top quality", new Category(1, "shelve")));
    products.push(new Product(13, "king size bed", 995.0, 1, "Top quality", new Category(1, "bed")));
    products.push(new Product(14, "single bed", 400.0, 1, "Top quality", new Category(1, "bed")));
    products.push(new Product(15, "lamp", 25.0, 1, "Top quality", new Category(1, "accessories")));

    return (
        <>
            <SearchProductsForm />
            <main className="mt-5">
                <h1 className="text-center mb-5 col-10 offset-1">Products (88- this should represent number of products based on search parameters)</h1>
                <div className="container">
                    <div className="row mt-5">
                        {products.map(p => (
                            <div className="col-sm-6 col-md-4 col-lg-3 mb-3" key={p.getId()}>
                                <ProductItem
                                    id={p.getId()}
                                    name={p.getName()}
                                    price={p.getPrice()}
                                    stock={p.getStock()}
                                    description={p.getDescription()}
                                    category={p.getCategory()}
                                />
                            </div>
                        ))}
                    </div>
                </div>
            </main>
        </>
    );
}