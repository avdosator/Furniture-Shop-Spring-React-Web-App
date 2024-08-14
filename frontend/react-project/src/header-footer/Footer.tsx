import { Link } from "react-router-dom"
import "./Footer.css"

export default function Footer() {
    return (
        <div className="bg-dark text-secondary py-1 footer bg-body-tertiary" data-bs-theme="dark">
            <footer className="container d-flex justify-content-around py-2">
                <p className="">&copy; Exclusive Furniture Store App</p>
                <p>Placeholder for logo</p>
                <Link className="" to="/contact">Contact</Link>
            </footer>
        </div>
    );
}