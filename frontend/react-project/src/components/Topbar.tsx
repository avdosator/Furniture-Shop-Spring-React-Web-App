export default function Topbar() {
    return (
        <div className="bg-secondary text-white py-1">
            <div className="container-fluid d-flex justify-content-between align-items-center">
                <div className="flex-grow-1 d-flex justify-content-center">
                    <p className="mb-0">
                        Sign up for latest news and discounts!
                    </p>
                </div>
                <div className="d-flex justify-content-end">
                    <button className="btn btn-sm btn-outline-light me-2">Login</button>
                    <button className="btn btn-sm btn-outline-light">Signup</button>
                    <button className="btn btn-sm btn-outline-light ms-2">Logout</button>
                </div>
            </div>
        </div>
    );
}