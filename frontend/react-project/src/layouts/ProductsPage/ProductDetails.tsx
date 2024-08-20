import { useLocation } from "react-router-dom"

export default function ProductDetails() {
    const location = useLocation();
    const {id, name, price, stock, description, category} = location.state || {};
    return (
        <div>
            <div className="col-6">
                <img src="https://via.placeholder.com/300x200" alt="" />
            </div>
            <div className="col-6">
                <h1 className="">{name}</h1>
                <h3 className="text-capitalize">Category: {category.name}</h3>
                <p>{price}</p>
                <p>{description}</p>
                <button>Add to cart</button>
            </div>
        </div>
    )
}