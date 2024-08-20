import { Link } from "react-router-dom"
import Category from "../../models/Category"
import "./ProductItem.css"

type ProductItemProps = {
    id: number,
    name: string,
    price: number,
    stock: number,
    description: string,
    category: Category
}

export default function ProductItem({ id, name, price, stock, description, category }: ProductItemProps) {
    return (
        <Link to={`/products/:{id}`} style={{textDecoration:"none"}}>
        <div className="card shadow product-item">
            <img src="https://via.placeholder.com/150x100" className="card-img-top p-3 card-image" alt="..." />
            <div className="card-body">
                <h5 className="card-title text-center">{name}</h5>
                <h6 className="card-text text-center">${price.toFixed(2)}</h6>
            </div>
        </div>
        </Link>
    )
}