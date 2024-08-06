export default function Topbar() {
    return (
        <div className="bg-secondary text-white py-1">
            <div className="container-fluid d-flex justify-content-end mx-0">
                <button className="btn btn-sm btn-outline-light me-2">Login</button>
                <button className="btn btn-sm btn-outline-light">Signup</button>
                <button className="btn btn-sm btn-outline-light ms-2">Logout</button>
            </div>
        </div>
    )
}