import { useState } from "react";
import { Link, useLocation } from "react-router-dom"
import "./ProductDetails.css"
import Select from "../../components/Select";

export default function ProductDetails() {
    const location = useLocation();
    const { id, name, price, stock, description, category } = location.state || {};
    let [amount, setAmount] = useState(1);

    function handleAmount(e: React.ChangeEvent<HTMLSelectElement | HTMLInputElement | HTMLTextAreaElement>): void {
        setAmount(parseInt(e.target.value));
    }

    function handleSubmit(e: React.FormEvent<HTMLFormElement>): void {
        e.preventDefault();
    }

    return (
        <div className="container my-5">
            <Link to={"/products"} className="back-button">All products</Link>
            <div className="row mt-5">
                <div className="col-lg-5 mb-3 d-none d-sm-block">
                    <img className="rounded" src="https://via.placeholder.com/450x300" alt="" />
                </div>
                <div className="d-sm-none mb-3">
                    <img className="rounded img-fluid w-100" src="https://via.placeholder.com/300x200" alt="" />
                </div>
                <div className="col-lg-5 offset-lg-1 offset-xl-0">
                    <h1 className="text-capitalize">{name}</h1>
                    <h3 className="text-capitalize">Category: {category.name}</h3>
                    <p className="fs-3">${price.toFixed(2)}</p>
                    <p className="lh-lg">{description} Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus velit delectus provident quae.
                        Itaque laudantium enim ad. Sequi earum voluptas temporibus, enim reiciendis dolorem unde vero dicta, placeat,
                        ducimus voluptate.
                    </p>
                    <form onSubmit={handleSubmit}>
                        <div className="form-floating mb-3">
                            <Select value={amount} id="amount" name="amount" onChange={handleAmount}
                                options={Array.from({ length: 10 }, (_, i) => i + 1)} /> {/* 10 should be defined dynamically based on number of products available */}
                            <label htmlFor="amount" className="">Amount</label>
                        </div>
                        <button className="btn btn-success">Add to cart</button> {/*<Link to={"/cart"}></Link>*/}
                    </form>
                </div>
            </div>
        </div>
    );
}