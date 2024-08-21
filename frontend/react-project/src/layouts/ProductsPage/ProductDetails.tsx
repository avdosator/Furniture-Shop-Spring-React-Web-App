import { useState } from "react";
import { useLocation } from "react-router-dom"

export default function ProductDetails() {
    const location = useLocation();
    const { id, name, price, stock, description, category } = location.state || {};
    let [amount, setAmount] = useState(1);

    function handleAmount(e: React.ChangeEvent<HTMLSelectElement>): void {
        setAmount(parseInt(e.target.value));
    }

    function generateOptions(num: number): JSX.Element[] {
        return Array.from({ length: num }, (_, index) => {
            const amount = index + 1;
            return (
                <option key={amount} value={amount}>
                    {amount}
                </option>
            );
        });
    }

    return (
        <div className="container mt-5">
            <div className="row mt-5">
                <div className="col-lg-6 mb-3 d-none d-sm-block">
                    <img className="rounded" src="https://via.placeholder.com/450x300" alt="" />
                </div>
                <div className="d-sm-none mb-3">
                    <img className="rounded img-fluid w-100" src="https://via.placeholder.com/300x200" alt="" />
                </div>
                <div className="col-lg-6">
                    <h1 className="text-capitalize">{name}</h1>
                    <h3 className="text-capitalize">Category: {category.name}</h3>
                    <p className="fs-3">${price.toFixed(2)}</p>
                    <p className="lh-lg">{description} Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus velit delectus provident quae.
                        Itaque laudantium enim ad. Sequi earum voluptas temporibus, enim reiciendis dolorem unde vero dicta, placeat,
                        ducimus voluptate.
                    </p>
                    <div className="form-floating mb-3">
                        <select id="amount"
                            name="amount"
                            className="form-select"
                            value={amount}
                            onChange={handleAmount}
                        >
                            {generateOptions(10)}
                        </select>
                        <label htmlFor="amount" className="">Amount</label>
                    </div>
                    <button className="btn btn-success">Add to cart</button> {/*<Link to={"/cart"}></Link>*/}
                </div>
            </div>
        </div>
    );
}