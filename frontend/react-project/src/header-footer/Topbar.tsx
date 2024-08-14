import { Link } from "react-router-dom";
import "./Topbar.css"

export default function Topbar() {
    return (
        <div className="bg-secondary text-white py-1">
            <div className="container-fluid d-flex justify-content-between align-items-center">
                <div className="flex-grow-1 d-flex justify-content-center">
                    <p className="mb-0" id="topbarMessage">
                        Sign up for latest news and discounts!
                    </p>
                    {/* <p>Welcome to F Store</p> First p should be rendered until user signs up, then render this or something else */}
                </div>
                <div className="d-flex justify-content-end">
                    <Link to="/login" className="btn btn-sm btn-outline-light me-2">Login</Link>
                    <Link to="/signup" className="btn btn-sm btn-outline-light">Signup</Link>
                    <Link to="#" className="btn btn-sm btn-outline-light ms-2">Logout</Link>
                </div>
            </div>
        </div>
    );
}