import { useEffect, useState } from "react";
import Category from "../../models/Category";
import Product from "../../models/Product";
import ProductItem from "./ProductItem";
import SearchProductsForm from "./SearchProductsForm";

export default function ProductsList() {
    let [products, setProducts] = useState<Product[]>([]);

    useEffect(() => {
        const getProducts = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/products", {
                    method: 'GET',
                    headers: {
                        'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzcGVsZSIsImlhdCI6MTcyNDI2MzExMiwiZXhwIjoxNzI0MjY2NzEyfQ.CJp6u8V5u8E9ORyuZkgz0xVYEq_jTaJk9gX0kfxHsOBfhEhZaMQ59lm7tovqCPtGy1sCI4NoBztRiY5XFJhMRA',
                    }
                });

                if (!response.ok) throw new Error(response.statusText);

                const resJson = await response.json();
                console.log(resJson);

                // Mapping response data to Product array
                const productsData: Product[] = resJson.map((item: any) => {
                    return new Product(
                        item.id,
                        item.name,
                        item.price,
                        item.stock,
                        item.description,
                        new Category(item.id, item.category.name) // Assuming your category object has these fields
                    );
                });

                setProducts(productsData);

            } catch (error) {
                console.log('Failed to fetch products:', error);
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