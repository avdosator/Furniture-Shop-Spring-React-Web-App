import { Link } from "react-router-dom";
import CartIcon from "../components/CartIcon";

export default function Navbar() {
    return (
        <nav className="navbar navbar-expand-lg bg-body-tertiary bg-dark border-bottom border-body sticky-top py-2" data-bs-theme="dark">
            <div className="container">
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03"
                    aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <Link className="navbar-brand" to="/">F store</Link>
                <div className="collapse navbar-collapse" id="navbarToggler">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <Link className="nav-link" aria-current="page" to="/home">Home</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/about">About</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/products">Products</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/latest">Latest</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/contact">Contact</Link>
                        </li>
                    </ul>
                    <form className="d-flex" role="search">
                        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                        <button className="btn btn-outline-success" type="submit">Search</button>
                    </form>
                    <div className="ms-lg-4 me-lg-2 mt-3 mt-lg-0">
                        <a href="#" className="position-relative">
                            <CartIcon />
                            <span className="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
                                style={{ fontSize: '0.60rem', padding: '0.25em 0.55em' }}>
                                5
                            </span>
                        </a>
                    </div>
                </div>
            </div>
        </nav>
    )
}