import { useState } from "react";

export default function AddProductForm() {
    let [formData, setFormData] = useState({ productName: "", price: 0.0, stock: 1, description: "", category: "" });
    let categories: string[] = ["chair", "double bed", "kitchen", "table"];

    function handleChange(e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>): void {
        let { name, value } = e.target;

        setFormData(oldData => ({
            ...oldData,
            [name]: value
        }));
    }

    function handleReset(): void {
        setFormData({ productName: "", price: 0, stock: 1, description: "", category: "" });
    }

    function handleSubmit(e: React.FormEvent<HTMLFormElement>): void {
        e.preventDefault();
        console.log(formData);
        //logic for sending request to create product
        setFormData({ productName: "", price: 0, stock: 1, description: "", category: "" });
    }

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-10 offset-md-1 col-lg-8 offset-lg-2 col-xl-6 offset-xl-3">
                <form onSubmit={handleSubmit}>
                    <h4 className="my-4 text-center">Add new product</h4>
                    <div className="form-floating mb-3">
                        <input type="text"
                            className="form-control"
                            value={formData.productName}
                            id="productName"
                            name="productName"
                            onChange={handleChange}
                            placeholder="Enter product name"
                            autoFocus
                        />
                        <label htmlFor="productName">Product name</label>
                    </div>
                    <div className="row">
                        <div className="form-floating mb-3 col-6">
                            <input type="number"
                                className="form-control"
                                value={formData.price}
                                id="productPrice"
                                name="price"
                                onChange={handleChange}
                                placeholder="Enter product price"
                            />
                            <label htmlFor="productPrice" className="ms-2">Price</label>
                        </div>
                        <div className="form-floating mb-3 col-6">
                            <input type="number"
                                className="form-control"
                                value={formData.stock}
                                id="numberOfProducts"
                                name="stock"
                                onChange={handleChange}
                                placeholder="Enter number of products adding"
                                min={0}
                            />
                            <label htmlFor="numberOfProducts" className="ms-2">Number of products</label>
                        </div>
                    </div>
                    <div className="form-floating mb-3">
                        <textarea
                            className="form-control"
                            value={formData.description}
                            id="productDescription"
                            name="description"
                            onChange={handleChange}
                            placeholder="Enter product description"
                            rows={5}>
                        </textarea>
                        <label htmlFor="productDescription">Description</label>
                    </div>
                    <div className="form-floating mb-3">
                        <select name="category" id="productCategory" className="form-control"
                            value={formData.category}
                            onChange={handleChange}
                        >
                            {categories.map((category, index) => (
                                <option key={index} value={category}>
                                    {category.charAt(0).toUpperCase() + category.slice(1).toLowerCase()}
                                </option>
                            ))}
                        </select>
                        <label htmlFor="productCategory">Select category</label>
                    </div>
                    <div>
                        <button type="submit" className="btn btn-success col-6">Submit</button>
                        <button type="button" className="btn btn-danger col-6" onClick={handleReset}>Reset</button>
                    </div>
                </form>
            </div>
        </div>
        </div>
    );
}