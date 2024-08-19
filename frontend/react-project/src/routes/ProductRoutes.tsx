import { Route, Routes } from "react-router-dom";
import SearchProductsForm from "../layouts/ProductsPage/SearchProductsForm";
import AddProductForm from "../components/AddProductForm";

export default function ProductRoutes() {
    return (
        <Routes>
            <Route index element={<SearchProductsForm /> /* this element will be part of ProductList component */} />
            <Route path=':id' element={<h1>Placeholder for single product page</h1>} />
            <Route path='new' element={<AddProductForm />} />
        </Routes>
    );
}