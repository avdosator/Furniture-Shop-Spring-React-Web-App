export default function SignupForm() {
    return (
        <form>
            <h4>Sign up</h4>
            <div>
                <label htmlFor="">Firstname</label>
                <input type="text" />
            </div>
            <div>
                <label htmlFor="">Lastname</label>
                <input type="text" />
            </div>
            <div>
                <label htmlFor="">Username</label>
                <input type="text" />
            </div>
            <div>
                <label htmlFor="">Password</label>
                <input type="password" />
            </div>
            <div>
                <label htmlFor="">Email</label>
                <input type="email" />
            </div>
        </form>
    )
}