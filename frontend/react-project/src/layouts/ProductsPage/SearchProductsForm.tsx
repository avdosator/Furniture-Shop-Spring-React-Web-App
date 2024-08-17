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
                    <label htmlFor=""></label>
                    <input type="text" />
                </div>
                <div>
                    <label htmlFor=""></label>
                    <input type="text" />
                </div>
                <div>
                    <label htmlFor=""></label>
                    <input type="text" />
                </div>
                <div>
                    <label htmlFor=""></label>
                    <input type="text" />
                </div>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </form>
        </div>
    )
}