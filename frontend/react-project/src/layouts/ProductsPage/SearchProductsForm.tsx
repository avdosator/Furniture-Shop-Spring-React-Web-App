import { useState } from "react";

export default function SearchProductsForm() {
    let [searchParameters, setSearchParameters] = useState({ productName: "", category: "", sortBy: "" });
    let [priceRange, setPriceRange] = useState({ minPrice: 0, maxPrice: 10000 }); //implement to set maxPrice to most expensive product price

    function handleSubmit(e: React.FormEvent<HTMLFormElement>): void {
        e.preventDefault();
        console.log(searchParameters);
        console.log(priceRange);
        //logic for searching products
        setSearchParameters({ productName: "", category: "", sortBy: "" });
        setPriceRange({ minPrice: 0, maxPrice: 10000 });
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="productName">Product name</label>
                    <input type="text"
                    id="productName"
                    name="productName"
                     />
                </div>
                <div>
                    <label htmlFor="category">Category</label>
                    <input type="text"
                    id="category"
                    name="category"
                     />
                </div>
                <div>
                    <label htmlFor="sortBy">Sort By</label>
                    <input type="text"
                    id="sortBy"
                    name="sortBy"
                    />
                </div>
                <div>
                    <label htmlFor="priceRange">Price range</label>
                    <input type="text"
                    id="priceRange"
                    name="priceRange"                    
                    />
                </div>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </form>
        </div>
    )
}