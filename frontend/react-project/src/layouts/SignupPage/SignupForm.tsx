import { useState } from "react";

export default function SignupForm() {
    let [formData, setFormData] = useState({ firstname: "", lastname: "", username: "", password: "", email: "" });

    return (
        <form>
            <h4>Sign up</h4>
            <div>
                <label htmlFor="firstname">Firstname</label>
                <input type="text"
                    value={formData.firstname}
                    id="firstname"
                    name="firstname"
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
                    placeholder="Enter your lastname"
                />
            </div>
            <div>
                <label htmlFor="createUserUsername">Username</label>
                <input type="text"
                    value={formData.username}
                    id="createUserUsername"
                    name="firstname"
                    placeholder="Enter your username"
                />
            </div>
            <div>
                <label htmlFor="createUserPassword">Password(8-20 characters)</label>
                <input type="password"
                    value={formData.password}
                    id="createUserPassword"
                    name="firstname"
                    placeholder="Enter your password (8-20 characters)"
                />
            </div>
            <div>
                <label htmlFor="email">Email</label>
                <input type="email"
                    value={formData.email}
                    id="email"
                    name="firstname"
                    placeholder="Enter your email"
                />
            </div>
        </form>
    )
}