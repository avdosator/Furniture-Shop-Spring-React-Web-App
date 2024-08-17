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

    return (
        <form>
            <h4>Sign up</h4>
            <div>
                <label htmlFor="firstname">Firstname</label>
                <input type="text"
                    value={formData.firstname}
                    id="firstname"
                    name="firstname"
                    onChange={handleChange}
                    placeholder="Enter your firstname"
                    autoFocus
                />
            </div>
            <div>
                <label htmlFor="lastname">Lastname</label>
                <input type="text"
                    value={formData.lastname}
                    id="lastname"
                    name="firstname"
                    onChange={handleChange}
                    placeholder="Enter your lastname"
                />
            </div>
            <div>
                <label htmlFor="createUserUsername">Username</label>
                <input type="text"
                    value={formData.username}
                    id="createUserUsername"
                    name="firstname"
                    onChange={handleChange}
                    placeholder="Enter your username"
                />
            </div>
            <div>
                <label htmlFor="createUserPassword">Password(8-20 characters)</label>
                <input type="password"
                    value={formData.password}
                    id="createUserPassword"
                    name="firstname"
                    onChange={handleChange}
                    placeholder="Enter your password (8-20 characters)"
                />
            </div>
            <div>
                <label htmlFor="email">Email</label>
                <input type="email"
                    value={formData.email}
                    id="email"
                    name="firstname"
                    onChange={handleChange}
                    placeholder="Enter your email"
                />
            </div>
        </form>
    )
}