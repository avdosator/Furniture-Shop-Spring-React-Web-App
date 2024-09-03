import { useEffect, useState } from "react";
import 'rc-slider/assets/index.css';
import Slider from 'rc-slider';
import Input from "../../components/Input";
import Select from "../../components/Select";
import Utils from "../../utils/Utils";
import { useCategories } from "../../context/CategoryContext";

export default function SearchProductsForm({ maxPrice }: { maxPrice: number }) {
    let [searchParameters, setSearchParameters] = useState({ productName: "", category: "all", sortBy: "name (ascending)" });
    let [priceRange, setPriceRange] = useState([0, maxPrice]);

    const { categories } = useCategories();

    useEffect(() => {
        setPriceRange([0, maxPrice]); // Update price range whenever maxPrice changes
    }, [maxPrice]);

    function handleChange(e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>): void {
        let { name, value } = e.target as HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement;
        setSearchParameters(oldData => ({
            ...oldData,
            [name]: value
        }));
    }

    function handleSliderChange(value: number | number[]): void {
        if (Array.isArray(value)) setPriceRange([value[0], value[1]]);
    }

    function handleReset(): void {
        setSearchParameters({ productName: "", category: "all", sortBy: "name (ascending)" });
        setPriceRange([0, maxPrice]);
    }

    function handleSubmit(e: React.FormEvent<HTMLFormElement>): void {
        e.preventDefault();
        console.log(searchParameters);
        console.log(priceRange);
        //logic for searching products
        setSearchParameters({ productName: "", category: "", sortBy: "" });
        setPriceRange([0, maxPrice]);
    }

    return (
        <div className="container mt-3">
            <div className="col-lg-10 offset-lg-1 bg-success-subtle text-success-emphasis rounded p-2">
                <form onSubmit={handleSubmit}>
                    <div className="row">
                        <div className="form-floating mb-3 col-md-4">
                            <Input type="text" className="form-control" value={searchParameters.productName} id="productName"
                                name="productName" onChange={handleChange} />
                            <label htmlFor="productName" className="ms-2">Product Name</label>
                        </div>
                        <div className="row col-md-8 pe-0 pe-md-1">
                            <div className="form-floating mb-3 col-sm-6 pe-0 pe-md-1">
                                <Select value={searchParameters.category} id="category" name="category" onChange={handleChange}
                                    options={["all", ...categories.map((category) => category.getName())]} />
                                <label htmlFor="category" className="ms-2">Category</label>
                            </div>
                            <div className="form-floating mb-3 col-sm-6 pe-0 pe-md-1">
                                <Select value={searchParameters.sortBy} id="sortBy" name="sortBy" onChange={handleChange}
                                    options={Utils.getSortingOptions()} />
                                <label htmlFor="sortBy" className="ms-2">Sort By</label>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="mb-3 col-md-6">
                            <label className="form-label">Price range</label>
                            <Slider range min={0} max={maxPrice} step={10} value={priceRange} onChange={handleSliderChange} />
                            <div className="d-flex justify-content-between">
                                <span>{priceRange[0]}</span>
                                <span>{priceRange[1]}</span>
                            </div>
                        </div>
                        <div className="col-md-6 mt-2 pt-md-3">
                            <button type="submit" className="btn btn-success ms-lg-5 px-4">Submit</button>
                            <button type="button" className="btn btn-danger ms-3 px-4" onClick={handleReset}>Reset</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    )
}