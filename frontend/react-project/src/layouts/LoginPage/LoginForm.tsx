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
        const login = async () => {
            const requestOptions = {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    username: formData.username,
                    password: formData.password
                })
            }

            const response: Response = await fetch("http://localhost:8080/login", requestOptions);
            if (!response.ok) throw new Error(response.statusText);

            const resJson = await response.json();
            setFormData({ username: "", password: "" });
            console.log(resJson);

            localStorage.setItem("accessToken", JSON.stringify(resJson));
        }

        login();
    }

    return (
        <div className="container d-flex align-items-center justify-content-center mt-4">
            <div className="row">
                <div className="col-md-8 offset-md-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 mb-1">
                    <div className="card shadow">
                        <div>
                            <img src="https://plus.unsplash.com/premium_photo-1681487814165-018814e29155?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                                alt="" className="card-img-top" crossOrigin="anonymous" />
                        </div>
                        <div className="card-body">
                            <form onSubmit={handleSubmit} >
                                <h4 className="card-title text-center mb-3">Login</h4>
                                <div className="mb-3 form-floating">
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
                                    <label htmlFor="username" className="form-label fw-medium">Username</label>
                                </div>
                                <div className="mb-3 form-floating">
                                    <input type="password"
                                        className="form-control"
                                        value={formData.password}
                                        id="password"
                                        name="password"
                                        onChange={handleChange}
                                        placeholder="Enter your password"
                                        autoComplete="current-password"
                                    />
                                    <label htmlFor="password" className="form-label fw-medium">Password</label>
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