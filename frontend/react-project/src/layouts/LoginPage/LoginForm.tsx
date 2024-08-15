import { useState } from "react";

export default function LoginForm() {
    let [formData, setFormData] = useState({username: "", password: ""});

    function handleChange(e: React.ChangeEvent<HTMLInputElement>): void {
        let {name, value} = e.target as HTMLInputElement;
        setFormData(oldData => {
            return {
                ...oldData,
                [name]: value
            }
        })
    }

    function handleSubmit(e:React.FormEvent<HTMLFormElement> ): void {
        e.preventDefault();
        console.log(formData);
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
                onChange={handleChange}
                placeholder="Enter your username here"
                autoFocus
            />
            <label htmlFor="password">Password</label>
            <input type="password"
                value={formData.password}
                id="password"
                name="password"
                onChange={handleChange}
                placeholder="Password"
            />
            <button type="submit">Log In</button>
        </form>
    );
}