import { Link } from "react-router-dom"
import Category from "../../models/Category"

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
        <div className="card">
            <img src="https://via.placeholder.com/200x200" alt="..." />
            <div className="card-body">
                <h5 className="card-title">{name}</h5>
                <h6>{category.getName()}</h6>
                <h6 className="">{price}</h6>
                <Link to={`/products/:{id}`}>View Product</Link>
            </div>
        </div>
    )
}