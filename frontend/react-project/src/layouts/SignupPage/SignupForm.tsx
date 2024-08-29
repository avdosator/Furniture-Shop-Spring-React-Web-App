import { useState } from "react";
import { useNavigate } from "react-router-dom";
import User from "../../models/User";
import ApiService from "../../service/ApiService";
import { LoginResponse } from "../LoginPage/LoginForm";
import Input from "../../components/Input";

type SignupResponse = {
    id: number,
    firstname: string,
    lastname: string,
    username: string,
    email: string,
    password: string,
    dateCreated: Date,
    role: string
}

export default function SignupForm() {
    let [formData, setFormData] = useState({ firstname: "", lastname: "", username: "", password: "", email: "" });
    const navigate = useNavigate();

    function handleChange(e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>): void {
        let { name, value } = e.target as HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement;
        setFormData(oldData => {
            return {
                ...oldData,
                [name]: value
            }
        });
    }

    function handleSubmit(e: React.FormEvent<HTMLFormElement>): void {
        e.preventDefault();

        const register = async () => {
            const body = {
                firstname: formData.firstname,
                lastname: formData.lastname,
                username: formData.username,
                password: formData.password,
                email: formData.email
            }

            try {
                // user creation
                const registeredUser = await ApiService.call<SignupResponse>("users", "POST", body);
                // do I need this user...
                const user = new User(registeredUser.id,
                    registeredUser.firstname,
                    registeredUser.lastname,
                    registeredUser.username,
                    registeredUser.email,
                    registeredUser.password,
                    registeredUser.dateCreated,
                    registeredUser.role);
                alert(`Hello ${formData.username}, you successfully created an account!`);
                // user login    
                const loginResponse = await ApiService.call<LoginResponse>("login", "POST", { username: formData.username, password: formData.password });
                localStorage.setItem("accessToken", JSON.stringify(loginResponse));

                setFormData({ firstname: "", lastname: "", username: "", password: "", email: "" });
                navigate("/home", { replace: true });
            } catch (e) {
                console.error("Error during signup or login", e);
            }
        }

        register();
    }

    
   {/* function handleSubmit(e: React.FormEvent<HTMLFormElement>): void {
        e.preventDefault();

        const register = () => {
            const body = {
                firstname: formData.firstname,
                lastname: formData.lastname,
                username: formData.username,
                password: formData.password,
                email: formData.email
            }
            try {
                // user creation
                ApiService.call<SignupResponse>("users", "POST", body).then((response) => {
                    const user = new User(response.id, // do I need this user...
                        response.firstname,
                        response.lastname,
                        response.username,
                        response.email,
                        response.password,
                        response.dateCreated,
                        response.role);
                    alert(`Hello ${formData.username}, you successfully created an account!`);
                })

                // user login    
                ApiService.call<LoginResponse>("login", "POST", { username: formData.username, password: formData.password }).then((response) => {
                    localStorage.setItem("accessToken", JSON.stringify(response));
                    setFormData({ firstname: "", lastname: "", username: "", password: "", email: "" });
                    navigate("/home", { replace: true });
                });
            } catch (e) {
                console.error("Error during signup or login", e);
            }
        }

        register();
    } */}

    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col-md-10 offset-md-1 col-lg-8 offset-lg-2 col-xl-6 offset-xl-3">
                    <form onSubmit={handleSubmit}>
                        <h4 className=" text-center fw-semibold mb-3">Sign up to F Store</h4>
                        <div className="mb-3 form-floating">
                            <Input type="text" className="form-control" value={formData.firstname} id="firstname" name="firstname"
                                onChange={handleChange} placeholder="Enter your firstname" autoFocus={true} />
                            <label htmlFor="firstname" className="form-label fw-medium">Firstname</label>
                        </div>
                        <div className="mb-3 form-floating">
                            <Input type="text" className="form-control" value={formData.lastname} id="lastname" name="lastname"
                                onChange={handleChange} placeholder="Enter your lastname" />
                            <label htmlFor="lastname" className="form-label fw-medium">Lastname</label>
                        </div>
                        <div className="mb-3 form-floating">
                            <Input type="text" className="form-control" value={formData.username} id="registerUsername"
                                name="username" onChange={handleChange} placeholder="Enter your username" autoComplete="username" />
                            <label htmlFor="registerUsername" className="form-label fw-medium">Username</label>
                        </div>
                        <div className="mb-3 form-floating">
                            <Input type="password" className="form-control" value={formData.password} id="registerPassword"
                                name="password" onChange={handleChange} placeholder="Enter your password" />
                            <label htmlFor="registerPassword" className="form-label fw-medium">Password</label>
                        </div>
                        <div className="mb-3 form-floating">
                            <Input type="email" className="form-control" value={formData.email} id="email" name="email"
                                onChange={handleChange} placeholder="Enter your email" autoComplete="email" />
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