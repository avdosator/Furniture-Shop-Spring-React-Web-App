import { Route, Routes } from "react-router-dom";
import AddProductForm from "../components/AddProductForm";
import ProductsList from "../layouts/ProductsPage/ProductsList";

export default function ProductRoutes() {
    return (
        <Routes>
            <Route index element={<ProductsList />} />
            <Route path=':id' element={<h1>Placeholder for single product page</h1>} />
            <Route path='new' element={<AddProductForm />} />
        </Routes>
    );
}