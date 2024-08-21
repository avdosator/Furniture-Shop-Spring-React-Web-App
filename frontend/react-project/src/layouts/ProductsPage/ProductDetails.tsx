import { useLocation } from "react-router-dom"

export default function ProductDetails() {
    const location = useLocation();
    const { id, name, price, stock, description, category } = location.state || {};

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
                <div className="col-6">
                    <img src="https://via.placeholder.com/450x300" alt="" />
                </div>
                <div className="col-6">
                    <h1 className="">{name}</h1>
                    <h3 className="text-capitalize">Category: {category.name}</h3>
                    <p>{price}</p>
                    <p className="lh-lg">{description} Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus velit delectus provident quae.
                        Itaque laudantium enim ad. Sequi earum voluptas temporibus, enim reiciendis dolorem unde vero dicta, placeat,
                        ducimus voluptate.
                    </p>
                    <div className="form-floating mb-3">
                        <select id="amount" name="amount" className="form-select"
                            
                        >
                            {generateOptions(10)}
                        </select>
                        <label htmlFor="amount" className="ms-2">Amount</label>
                    </div>
                    <button>Add to cart</button>
                </div>
            </div>
        </div>
    )
}