import { useState } from "react";
import Input from "../../components/Input";
import Select from "../../components/Select";
import { useCategories } from "../../context/CategoryContext";

export default function AddProductForm() {
    let [formData, setFormData] = useState({ productName: "", price: 0.0, stock: 1, description: "", category: "" });

    const {categories} = useCategories();

    function handleChange(e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>): void {
        let { name, value } = e.target as HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement;
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
        alert(`Product ${formData.productName} was successfully created!`);
        setFormData({ productName: "", price: 0, stock: 1, description: "", category: "" });
    }

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-10 offset-md-1 col-lg-8 offset-lg-2 col-xl-6 offset-xl-3">
                    <form onSubmit={handleSubmit}>
                        <h4 className="my-4 text-center">Add new product</h4>
                        <div className="form-floating mb-3">
                            <Input type="text" className="form-control" value={formData.productName} id="productName" name="productName"
                                onChange={handleChange} placeholder="Enter product name" autoFocus={true} />
                            <label htmlFor="productName">Product name</label>
                        </div>
                        <div className="row">
                            <div className="form-floating mb-3 col-6">
                                <Input type="number" className="form-control" value={formData.price} id="productPrice" name="price"
                                    onChange={handleChange} placeholder="Enter product price" />
                                <label htmlFor="productPrice" className="ms-2">Price</label>
                            </div>
                            <div className="form-floating mb-3 col-6">
                                <Input type="number" className="form-control" value={formData.stock} id="numberOfProducts"
                                    name="stock" onChange={handleChange} placeholder="Enter product price" />
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
                            <Select value="" id="productCategory" name="category" onChange={handleChange} 
                            options={categories.map((category) => category.getName())} />
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