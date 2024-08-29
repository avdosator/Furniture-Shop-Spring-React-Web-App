import { useEffect, useState } from "react";
import Category from "../../models/Category";
import Product from "../../models/Product";
import ProductItem from "./ProductItem";
import SearchProductsForm from "./SearchProductsForm";
import ApiService from "../../service/ApiService";

type ProductResponse = {
    id: number,
    name: string,
    price: number,
    stock: number,
    description: string,
    category: {
        id: number,
        name: string
    }
}

export default function ProductsList() {
    let [products, setProducts] = useState<Product[]>([]);

    useEffect(() => {
        const getProducts = () => {
            try {
                ApiService.call<ProductResponse[]>("api/products", "GET").then((products) => {
                    setProducts(products.map((item) => {
                        return new Product(
                            item.id,
                            item.name,
                            item.price,
                            item.stock,
                            item.description,
                            new Category(item.category.id, item.category.name)
                        );
                    }));
                });
            } catch (error) {
                console.log('Failed to fetch products:', error);
                alert("Request failed, try again");
            }
        };

        getProducts();
    }, []);

    return (
        <>
            <SearchProductsForm />
            <main className="mt-5">
                <p className="mb-5 col-10 offset-1 fw-bolder border-bottom pb-3"> {products.length} products</p>
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