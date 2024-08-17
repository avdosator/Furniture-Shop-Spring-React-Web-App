export default function SignupForm() {
    return (
        <form>
            <h4>Sign up</h4>
            <div>
                <label htmlFor="firstname">Firstname</label>
                <input type="text"
                    id="firstname"
                    name="firstname"
                    placeholder="Enter your firstname"
                    autoFocus
                />
            </div>
            <div>
                <label htmlFor="lastname">Lastname</label>
                <input type="text"
                    id="lastname"
                    name="firstname"
                    placeholder="Enter your lastname"
                />
            </div>
            <div>
                <label htmlFor="createUserUsername">Username</label>
                <input type="text"
                    id="createUserUsername"
                    name="firstname"
                    placeholder="Enter your username"
                />
            </div>
            <div>
                <label htmlFor="createUserPassword">Password(8-20 characters)</label>
                <input type="password"
                    id="createUserPassword"
                    name="firstname"
                    placeholder="Enter your password (8-20 characters)"
                />
            </div>
            <div>
                <label htmlFor="email">Email</label>
                <input type="email"
                    id="email"
                    name="firstname"
                    placeholder="Enter your email"
                />
            </div>
        </form>
    )
}