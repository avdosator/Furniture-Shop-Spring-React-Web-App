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
        <div className="container">

        
        <form onSubmit={handleSubmit}>
            <h4 className="card-title text-center">Sign up</h4>
            <div>
                <label htmlFor="firstname" className="form-label">Firstname</label>
                <input type="text"
                    className="form-control"
                    value={formData.firstname}
                    id="firstname"
                    name="firstname"
                    onChange={handleChange}
                    placeholder="Enter your firstname"
                    autoFocus
                />
            </div>
            <div>
                <label htmlFor="lastname" className="form-label">Lastname</label>
                <input type="text"
                    className="form-control"
                    value={formData.lastname}
                    id="lastname"
                    name="lastname"
                    onChange={handleChange}
                    placeholder="Enter your lastname"
                />
            </div>
            <div>
                <label htmlFor="createUserUsername" className="form-label">Username</label>
                <input type="text"
                    className="form-control"
                    value={formData.username}
                    id="createUserUsername"
                    name="username"
                    onChange={handleChange}
                    autoComplete="username"
                    placeholder="Enter your username"
                />
            </div>
            <div>
                <label htmlFor="createUserPassword" className="form-label">Password(8-20 characters)</label>
                <input type="password"
                    className="form-control"
                    value={formData.password}
                    id="createUserPassword"
                    name="password"
                    onChange={handleChange}
                    autoComplete="current-password"
                    placeholder="Enter your password (8-20 characters)"
                />
            </div>
            <div>
                <label htmlFor="email" className="form-label">Email</label>
                <input type="email"
                    className="form-control"
                    value={formData.email}
                    id="email"
                    name="email"
                    onChange={handleChange}
                    placeholder="Enter your email"
                />
            </div>
            <div>
                <button type="submit">Submit</button>
            </div>
        </form>
        </div>
    )
}