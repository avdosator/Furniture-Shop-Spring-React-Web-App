import "./Contact.css"

export default function Contact() {
    return (
        <div className="container my-5">
            <h1 className="text-center mb-3">Contact us</h1>
            <div className="row">
                <div className="col-md-6 mb-3">
                    <h3>Contact information</h3>
                    <p><strong>Address: </strong>Grand opening of store in Sarajevo - SOON!</p>
                    <p><strong>Phone: </strong> +38700-000-000</p>
                    <p><strong>Email: </strong> avdo.sator@hotmail.com</p>
                    <p><strong>LinkedIn: </strong><a href="https://www.linkedin.com/in/avdo-%C5%A1ator-725370308/">Avdo Sator</a></p>
                </div>
                <div className="col-md-6">
                    <h3>Send us a message</h3>
                    <form>
                        <div className="mb-3">
                            <label htmlFor="name" className="form-label">Name</label>
                            <input type="text" className="form-control" id="name" placeholder="Your Name" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="email" className="form-label">Email</label>
                            <input type="email" className="form-control" id="email" placeholder="Your Email" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="message" className="form-label">Message</label>
                            <textarea className="form-control" id="message" rows={5} placeholder="Your Message"></textarea>
                        </div>
                        <button type="submit" className="btn btn-primary">Send</button>
                    </form>
                </div>
            </div>
        </div>
    )
}