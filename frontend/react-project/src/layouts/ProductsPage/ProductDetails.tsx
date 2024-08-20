import { useLocation } from "react-router-dom"

export default function ProductDetails() {
    const location = useLocation();
    const {id, name, price, stock, description, category} = location.state || {};
    return (
        <div>
            <h1>{name}</h1>
            <h2>{price}</h2>
        </div>
    )
}