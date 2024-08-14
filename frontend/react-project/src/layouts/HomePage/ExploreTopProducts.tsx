import { Link } from "react-router-dom"
import "./ExploreTopProducts.css"

export default function ExploreTopProducts() {
    return (
        <div className="p-5 bg-dark mb-4" id="exploreTopProducts">
            <div className="container-fluid py-5 text-white d-flex justify-content-center align-items-center">
                <div>
                    <h1 className="display-5 fw-bold">Find best products for you</h1>
                    <p className="col-md-8 fs-4 text-indent-1">Explore our shop</p>
                    <Link type="button" to="/products" className="btn btn-lg btn-light text-indent-2">Explore Top Products</Link>
                </div>
            </div>
        </div>
    )
}