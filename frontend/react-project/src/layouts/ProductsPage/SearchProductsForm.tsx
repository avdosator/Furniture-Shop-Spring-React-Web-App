import { useState } from "react";

export default function SearchProductsForm() {
    let [searchParameters, setSearchParameters] = useState({ productName: "", category: "all", sortBy: "name (ascending)" });
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
        <div className="container mt-3">
            <div className="col-lg-10 offset-lg-1">
                <form onSubmit={handleSubmit}>
                    <div className="row">
                        {/* <div className="mb-3 col-lg-4 form-floating">
                            
                            <input type="text"
                                className="form-control"
                                id="productName"
                                name="productName"
                                value={searchParameters.productName}
                                onChange={handleChange}
                            />
                            <label htmlFor="productName" className="">Product name</label>
                        </div> */}
                        <div className="form-floating mb-3 col-md-4">
                            <input type="text" 
                            className="form-control" 
                            id="productName"
                             placeholder="email"
                             value={searchParameters.productName}
                             onChange={handleChange}
                             name="productName"
                              />
                            <label htmlFor="productName">Product Name</label>
                        </div>
                        <div className="row col-md-8">
                            <div className="form-floating mb-3 col-sm-6">
                                
                                <select id="category" name="category" className="form-select" defaultValue={searchParameters.category}>
                                    <option value="all" >All</option>
                                    <option value="chair">Chair</option>
                                    <option value="double bed">Double Bed</option>
                                    <option value="kitchen">Kitchen</option>
                                    <option value="table">Table</option>
                                </select>
                                <label htmlFor="category" className="form-label">Category</label>
                            </div>
                            <div className="form-floating mb-3 col-sm-6">
                                
                                <select id="sortBy" name="sortBy" className="form-select" defaultValue={searchParameters.sortBy}>
                                    <option value="name (ascending)">Name (ascending)</option>
                                    <option value="name (descending)">Name (descending)</option>
                                    <option value="price (ascending)">Price (ascending)</option>
                                    <option value="price (descending)">Price (descending)</option>
                                    <option value="newest">Newest</option>
                                </select>
                                <label htmlFor="sortBy" className="form-label">Sort By</label>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="mb-3 col-md-6">
                            <label htmlFor="priceRange" className="form-label">Price range</label>
                            <input type="range"
                                className="form-range"
                                id="priceRange"
                                name="priceRange"
                                min={0}
                                max={10000}
                                step={1}
                            />
                            <div className="">
                                <span>0</span>
                                <span>10 000</span>
                            </div>
                        </div>
                        <div className="col-md-6 mt-2">
                            <button type="submit" className="btn btn-success ms-lg-5 px-4">Submit</button>
                            <button type="reset" className="btn btn-danger ms-3 px-4">Reset</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    )
}