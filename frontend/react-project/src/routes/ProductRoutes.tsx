import { Route, Routes } from "react-router-dom";
import AddProductForm from "../layouts/ProductsPage/AddProductForm";
import ProductsList from "../layouts/ProductsPage/ProductsList";
import ProductDetails from "../layouts/ProductsPage/ProductDetails";

export default function ProductRoutes() {
    return (
        <Routes>
            <Route index element={<ProductsList />} />
            <Route path=':id' element={<ProductDetails />} />
            <Route path='new' element={<AddProductForm />} />
        </Routes>
    );
}