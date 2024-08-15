import { useState } from "react";

export default function LoginForm() {
    let [formData, setFormData] = useState({username: "", password: ""});

    function handleSubmit(e:React.FormEvent<HTMLFormElement> ): void {
        e.preventDefault();
        //logic for sending data to server
    }

    return (
        <form onSubmit={handleSubmit} >
            <h1>Login:</h1>
            <label htmlFor="username">Username</label>
            <input type="text"
                value={formData.username}
                id="username"
                name="username"
                placeholder="Enter your username here"
                autoFocus
            />
            <label htmlFor="password">Password</label>
            <input type="password"
                value={formData.password}
                id="password"
                name="password"
                placeholder="Password"
            />
            <button type="submit">Log In</button>
        </form>
    );
}