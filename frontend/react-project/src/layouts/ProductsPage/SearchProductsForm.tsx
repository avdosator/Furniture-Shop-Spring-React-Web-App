import { useState } from "react";

export default function SearchProductsForm() {
    let [searchParameters, setSearchParameters] = useState({ productName: "", category: "", sortBy: "" });
    let [priceRange, setPriceRange] = useState({ minPrice: 0, maxPrice: 10000 }); //implement to set maxPrice to most expensive product price

    function handleChange(e: React.ChangeEvent<HTMLInputElement>): void {
        let { name, value } = e.target as HTMLInputElement;
        setSearchParameters(oldData => {
            return {
                ...oldData,
                [name]: value
            }
        });
        setPriceRange(oldData => {
            return {
                ...oldData,
                [name]: value
            }
        });
    }

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
                        value={searchParameters.productName}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label htmlFor="category">Category</label>
                    <select id="category" name="category">
                        <option value="all" selected>All</option>
                        <option value="chair">Chair</option>
                        <option value="double bed">Double Bed</option>
                        <option value="kitchen">Kitchen</option>
                        <option value="table">Table</option>
                    </select>
                </div>
                <div>
                    <label htmlFor="sortBy">Sort By</label>
                    <select id="sortBy" name="sortBy">
                        <option value="name (ascending)" selected>Name (ascending)</option>
                        <option value="name (descending)">Name (descending)</option>
                        <option value="price (ascending)">Price (ascending)</option>
                        <option value="price (descending)">Price (descending)</option>
                        <option value="newest">Newest</option>
                    </select>
                </div>
                <div>
                    <label htmlFor="priceRange">Price range</label>
                    <input type="range"
                        id="priceRange"
                        name="priceRange"
                        min={0}
                        max={10000}
                        step={1}
                    />
                </div>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </form>
        </div>
    )
}