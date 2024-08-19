import { useState } from "react";

export default function AddProductForm() {
    let [formData, setFormData] = useState({ name: "", price: 0, stock: 0, description: "", category: "" });

    

    return (
        <div className="container">
            <form >
                <h4>Add new product</h4>
                <div>
                    <input type="text" id="productName" />
                    <label htmlFor="productName">Product name</label>
                </div>
                <div>
                    <input type="number" name="price" id="productPrice" />
                    <label htmlFor="productPrice">Price</label>
                </div>
                <div>
                    <input type="number" name="stock" id="numberOfProducts" />
                    <label htmlFor="numberOfProducts">Number of products</label>
                </div>
                <div>
                    <textarea name="description" id="productDescription" rows={3}></textarea>
                    <label htmlFor="productDescription">Description</label>
                </div>
                <div>
                    <select name="category" id="productCategory">

                    </select>
                    <label htmlFor="productCategory">Select category</label>
                </div>
                <div>
                    <button type="submit">Submit</button>
                    <button type="button">Reset</button>
                </div>
            </form>
        </div>
    );
}