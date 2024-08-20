import Category from "../../models/Category";
import Product from "../../models/Product";
import ProductItem from "./ProductItem";
import SearchProductsForm from "./SearchProductsForm";

export default function ProductsList() {

    let products: Product[] = [];
    products.push(new Product(1, "iron chair", 50.0, 1, "The best chair", new Category(1, "chair")));
    products.push(new Product(2, "double bed", 995.0, 1, "Top quality", new Category(1, "bed")));
    return (
        <>
            <SearchProductsForm />
            <main className="mt-5">
                <h1 className="text-center">Products (88- this should represent number of products based on search parameters)</h1>
                <div className="container">
                    <div className="d-flex row">
                        <div className="">
                        {products.map(p => (<ProductItem key={p.getId()}
                            id={p.getId()}
                            name={p.getName()}
                            price={p.getPrice()}
                            stock={p.getStock()}
                            description={p.getDescription()}
                            category={p.getCategory()}
                        />))}
                        </div>
                    </div>
                </div>
            </main>
        </>
    );
}