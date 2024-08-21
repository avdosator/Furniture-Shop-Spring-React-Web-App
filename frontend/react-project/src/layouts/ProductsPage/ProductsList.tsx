import { useEffect, useState } from "react";
import Category from "../../models/Category";
import Product from "../../models/Product";
import ProductItem from "./ProductItem";
import SearchProductsForm from "./SearchProductsForm";

export default function ProductsList() {

    let [products, setProducts] = useState<Product[]>([]);

    let fakeProducts: Product[] = [];
    fakeProducts.push(new Product(1, "iron chair", 50.0, 1, "The best chair", new Category(1, "chair")));
    fakeProducts.push(new Product(2, "wooden table", 195.0, 1, "Top quality", new Category(1, "bed")));
    fakeProducts.push(new Product(3, "double bed", 995.0, 1, "Top quality", new Category(1, "bed")));
    fakeProducts.push(new Product(4, "kitchen", 3500.0, 1, "Top quality", new Category(1, "kitchen")));
    fakeProducts.push(new Product(5, "sofa", 355.0, 1, "Top quality", new Category(1, "sofa")));
    fakeProducts.push(new Product(6, "table", 250.0, 1, "Top quality", new Category(1, "table")));
    fakeProducts.push(new Product(7, "chair", 45.0, 1, "Top quality", new Category(1, "chair")));
    fakeProducts.push(new Product(8, "closet", 1500.0, 1, "Top quality", new Category(1, "closet")));
    fakeProducts.push(new Product(9, "big mirror", 150.0, 1, "Top quality", new Category(1, "accessories")));
    fakeProducts.push(new Product(10, "gaming table", 300.0, 1, "Top quality", new Category(1, "table")));
    fakeProducts.push(new Product(11, "gaming chair", 250.0, 1, "Top quality", new Category(1, "chair")));
    fakeProducts.push(new Product(12, "shelves", 199.0, 1, "Top quality", new Category(1, "shelve")));
    fakeProducts.push(new Product(13, "king size bed", 995.0, 1, "Top quality", new Category(1, "bed")));
    fakeProducts.push(new Product(14, "single bed", 400.0, 1, "Top quality", new Category(1, "bed")));
    fakeProducts.push(new Product(15, "lamp", 25.0, 1, "Top quality", new Category(1, "accessories")));

    useEffect(() => {
        const getProducts = async () => {
            try {
                const response = await fetch("http://localhost:8080/products", {
                    method: 'GET',
                    headers: {
                        'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzcGVsZSIsImlhdCI6MTcyNDI0OTc4OCwiZXhwIjoxNzI0MjUzMzg4fQ.Us67KDx4-kYBaKF-20nsORHU4UPM_Pv3oSfW4LQle0qc3IVvB-i9TW9bI7aHtrMbj1xuyuTZPD8eLXEU_Vumfg',
                    }
                });
                if (!response.ok) throw new Error(response.statusText);
                const resJson = await response.json();
                console.log(resJson);
                const productsData: Product[] = resJson.map((item: any) => ({
                    id: item.id,
                    name: item.name,
                    price: item.price,
                    stock: item.stock,
                    description: item.description,
                    category: new Category(item.id, item.name),
                }));

                setProducts(productsData);

            } catch (error) {
                console.log(error);
            }
        }
        getProducts();
    }, [])

    return (
        <>
            <SearchProductsForm />
            <main className="mt-5">
                <p className="mb-5 col-10 offset-1 fw-bolder border-bottom pb-3"> {fakeProducts.length} products</p>
                <div className="container">
                    <div className="row mt-5">
                        {fakeProducts.map(p => (
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