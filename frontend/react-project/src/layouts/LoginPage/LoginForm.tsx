import { useState } from "react";

export default function LoginForm() {
    let [formData, setFormData] = useState({ username: "", password: "" });

    function handleChange(e: React.ChangeEvent<HTMLInputElement>): void {
        let { name, value } = e.target as HTMLInputElement;
        setFormData(oldData => {
            return {
                ...oldData,
                [name]: value
            }
        });
    }

    function handleSubmit(e: React.FormEvent<HTMLFormElement>): void {
        e.preventDefault();
        console.log(formData);
        //logic for sending data to server
        setFormData({ username: "", password: "" });
    }

    return (
        <div className="container d-flex align-items-center justify-content-center mt-3">
            <div className="row">
                <div className="col-md-8 offset-md-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 mb-1">
                    <div className="card shadow">
                        <div>
                            <img src="https://plus.unsplash.com/premium_photo-1681487814165-018814e29155?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                                alt="" className="card-img-top" crossOrigin="anonymous" />
                        </div>
                        <div className="card-body">
                            <form onSubmit={handleSubmit} >
                                <h4 className="card-title text-center">Login</h4>
                                <div className="mb-3">
                                    <label htmlFor="username" className="form-label fw-medium">Username</label>
                                    <input type="text"
                                        className="form-control"
                                        value={formData.username}
                                        id="username"
                                        name="username"
                                        onChange={handleChange}
                                        placeholder="Enter your username"
                                        autoComplete="username"
                                        autoFocus
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="password" className="form-label fw-medium">Password</label>
                                    <input type="password"
                                        className="form-control"
                                        value={formData.password}
                                        id="password"
                                        name="password"
                                        onChange={handleChange}
                                        placeholder="Enter your password"
                                        autoComplete="current-password"
                                    />
                                </div>
                                <div className="d-grid gap-2">
                                    <button type="submit" className="btn btn-success fw-semibold">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}