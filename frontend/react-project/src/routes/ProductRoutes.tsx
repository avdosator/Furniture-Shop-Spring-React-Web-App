import { Route, Routes } from "react-router-dom";

export default function ProductRoutes() {
    return (
        <Routes>
            <Route index element={<h1>Placeholder for "products" page</h1>} />
            <Route path=':id' element={<h1>Placeholder for single product page</h1>} />
            <Route path='new' element={<h1>Placeholder for adding new product</h1>} />
        </Routes>
    );
}