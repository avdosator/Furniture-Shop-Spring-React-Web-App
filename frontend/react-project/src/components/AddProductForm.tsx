import { useState } from "react";

export default function AddProductForm() {
    let [formData, setFormData] = useState({ productName: "", price: 0, stock: 0, description: "", category: "" });
    let categories: string[] = ["chair", "double bed", "kitchen", "table"];


    return (
        <div className="container">
            <form >
                <h4>Add new product</h4>
                <div>
                    <input type="text"
                        className=""
                        value={formData.productName}
                        id="productName"
                        name="productName"
                        onChange={handleChange}
                        placeholder="Enter product name"
                        autoFocus
                    />
                    <label htmlFor="productName">Product name</label>
                </div>
                <div>
                    <input type="number"
                        className=""
                        value={formData.price}
                        id="productPrice"
                        name="price"
                        onChange={handleChange}
                        placeholder="Enter product price"
                    />
                    <label htmlFor="productPrice">Price</label>
                </div>
                <div>
                    <input type="number"
                        className=""
                        value={formData.stock}
                        id="numberOfProducts"
                        name="stock"
                        onChange={handleChange}
                        placeholder="Enter number of products adding"
                    />
                    <label htmlFor="numberOfProducts">Number of products</label>
                </div>
                <div>
                    <textarea
                        className=""
                        value={formData.description}
                        id="productDescription"
                        name="description"
                        onChange={handleChange}
                        placeholder="Enter product description"
                        rows={3}>
                    </textarea>
                    <label htmlFor="productDescription">Description</label>
                </div>
                <div>
                    <select name="category" id="productCategory"
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
                    <button type="submit">Submit</button>
                    <button type="button">Reset</button>
                </div>
            </form>
        </div>
    );
}