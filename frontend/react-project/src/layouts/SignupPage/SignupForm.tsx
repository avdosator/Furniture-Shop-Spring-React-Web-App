import { useState } from "react";

export default function SignupForm() {
    let [formData, setFormData] = useState({ firstname: "", lastname: "", username: "", password: "", email: "" });

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
        setFormData({ firstname: "", lastname: "", username: "", password: "", email: "" });
    }

    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col-md-10 offset-md-1 col-lg-8 offset-lg-2 col-xl-6 offset-xl-3">
                    <form onSubmit={handleSubmit}>
                        <h4 className=" text-center fw-semibold mb-3">Sign up to F Store</h4>
                        <div className="mb-3 form-floating">

                            <input type="text"
                                className="form-control"
                                value={formData.firstname}
                                id="firstname"
                                name="firstname"
                                onChange={handleChange}
                                placeholder="Enter your firstname"
                                autoFocus
                            />
                            <label htmlFor="firstname" className="form-label fw-medium">Firstname</label>
                        </div>
                        <div className="mb-3 form-floating">
                            <input type="text"
                                className="form-control"
                                value={formData.lastname}
                                id="lastname"
                                name="lastname"
                                onChange={handleChange}
                                placeholder="Enter your lastname"
                            />
                            <label htmlFor="lastname" className="form-label fw-medium">Lastname</label>
                        </div>
                        <div className="mb-3 form-floating">

                            <input type="text"
                                className="form-control"
                                value={formData.username}
                                id="createUserUsername"
                                name="username"
                                onChange={handleChange}
                                autoComplete="username"
                                placeholder="Enter your username"
                            />
                            <label htmlFor="createUserUsername" className="form-label fw-medium">Username</label>
                        </div>
                        <div className="mb-3 form-floating">

                            <input type="password"
                                className="form-control"
                                value={formData.password}
                                id="createUserPassword"
                                name="password"
                                onChange={handleChange}
                                autoComplete="current-password"
                                placeholder="Enter your password (8-20 characters)"
                            />
                            <label htmlFor="createUserPassword" className="form-label fw-medium">Password</label>
                        </div>
                        <div className="mb-3 form-floating">

                            <input type="email"
                                className="form-control"
                                value={formData.email}
                                id="email"
                                name="email"
                                onChange={handleChange}
                                placeholder="Enter your email"
                            />
                            <label htmlFor="email" className="form-label fw-medium">Email</label>
                        </div>
                        <div className="d-grid gap-2 mt-3">
                            <button type="submit" className="btn btn-success fw-semibold">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}