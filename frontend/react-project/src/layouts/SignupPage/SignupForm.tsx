export default function SignupForm() {
    return (
        <form>
            <h4>Sign up</h4>
            <div>
                <label htmlFor="firstname">Firstname</label>
                <input type="text"
                    id="firstname"
                    name="firstname"
                />
            </div>
            <div>
                <label htmlFor="lastname">Lastname</label>
                <input type="text"
                    id="lastname"
                    name="firstname"
                />
            </div>
            <div>
                <label htmlFor="createUserUsername">Username</label>
                <input type="text"
                    id="createUserUsername"
                    name="firstname"
                />
            </div>
            <div>
                <label htmlFor="createUserPassword">Password</label>
                <input type="password"
                    id="createUserPassword"
                    name="firstname"
                />
            </div>
            <div>
                <label htmlFor="email">Email</label>
                <input type="email"
                    id="email"
                    name="firstname"
                />
            </div>
        </form>
    )
}