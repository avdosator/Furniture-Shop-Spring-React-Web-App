import { useState } from "react";
import { useNavigate } from "react-router-dom";
import ApiService from "../../service/ApiService";
import Input from "../../components/Input";

export type LoginResponse = {
    token: string,
    expiresIn: number
}

export default function LoginForm() {
    let [formData, setFormData] = useState({ loginUsername: "", loginPassword: "" });
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
        const login = async () => {
            const resJson = await ApiService.call<LoginResponse>("login", "POST", { username: formData.loginUsername, password: formData.loginPassword });
            localStorage.setItem("accessToken", JSON.stringify(resJson));
            alert(`Hello ${formData.loginUsername}, you are logged in!`);
            setFormData({ loginUsername: "", loginPassword: "" });
            navigate("/home", { replace: true });
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
                                    <Input type="text" className="form-control" value={formData.loginUsername} id="loginUsername"
                                        name="loginUsername" onChange={handleChange} placeholder="Enter your username"
                                        autoComplete="username" autoFocus={true} />
                                    <label htmlFor="loginUsername" className="form-label fw-medium">Username</label>
                                </div>
                                <div className="mb-3 form-floating">
                                    <Input type="password" className="form-control" value={formData.loginPassword} id="loginPassword"
                                        name="loginPassword" onChange={handleChange} placeholder="Enter your password"
                                        autoComplete="current-password" />
                                    <label htmlFor="loginPassword" className="form-label fw-medium">Password</label>
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