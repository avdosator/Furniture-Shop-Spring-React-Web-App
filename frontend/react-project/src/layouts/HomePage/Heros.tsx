import { Link } from "react-router-dom";
import "./Heros.css"

export default function Heros() {
    return (
        <div className="container pb-5">
            <div className="d-none d-lg-block">
                <div className="row g-0 mt-5">
                    <div className="col-sm-6 col-md-6">
                        <div className="col-image-left"></div>
                    </div>
                    <div className="col-4 col-md-4 container d-flex justify-content-center align-items-center">
                        <div className="ml-2">
                            <h1>What are you looking for?</h1>
                            <p className="lead">
                                Our team would love to know what products are you interested in.
                                Whether it is some luxury bed for your bedroom or some cozy detail for living room,
                                we will be able to provide top products for you!
                            </p>
                            <Link to="/signup" className="btn btn-dark btn-lg text-white">Sign Up</Link>
                        </div>
                    </div>
                </div>
                <div className="row g-0">
                    <div className="col-4 col-md-4 container d-flex justify-content-center align-items-center">
                        <div className="ml-2">
                            <h1>Our collection is always changing!</h1>
                            <p className="lead">
                                Try to check in daily as our collection is always changing!
                                We work nonstop to provide the best selection possible
                                for customers! Our products are always top quality, made of the best
                                materials on the market.
                            </p>
                        </div>
                    </div>
                    <div className="col-sm-6 col-md-6">
                        <div className="col-image-right"></div>
                    </div>
                </div>
            </div>

            {/* Mobile */}
            <div className="d-lg-none mt-5">
                <div className="row g-0">
                    <div className="col-12">
                        <div className="col-image-left"></div>
                    </div>
                    <div className="col-12 container d-flex justify-content-center align-items-center mt-3">
                        <div className="ml-2">
                            <h1>What are you looking for?</h1>
                            <p className="lead">
                                Our team would love to know what products are you interested in.
                                Whether it is some luxury bed for your bedroom or some cozy detail for living room,
                                we will be able to provide top products for you!
                            </p>
                            <a href="#" className="btn btn-dark btn-lg text-white">Sign Up</a>
                        </div>
                    </div>
                </div>
                <div className="row g-0 mt-3">
                    <div className="col-12 container d-flex justify-content-center align-items-center">
                        <div className="ml-2">
                            <h1>Our collection is always changing!</h1>
                            <p className="lead">
                                Try to check in daily as our collection is always changing!
                                We work nonstop to provide the best selection possible
                                for customers! Our products are always top quality, made of the best
                                materials on the market.
                            </p>
                        </div>
                    </div>
                    <div className="col-12 mt-3">
                        <div className="col-image-right"></div>
                    </div>
                </div>
            </div>
        </div>
    );
}