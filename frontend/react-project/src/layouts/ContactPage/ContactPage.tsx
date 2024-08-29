import Input from "../../components/Input";
import "./ContactPage.css"

export default function Contact() {
    return (
        <div className="container contact-container my-5 mt-5">
            <h1 className="text-center mb-4">Contact Us</h1>
            <div className="card mb-4">
                <img src="https://via.placeholder.com/900x300" className="card-img-top" alt="Contact Us" />
                <div className="card-body">
                    <div className="row">
                        <div className="col-md-6 mb-4">
                            <h3 className="mb-5">Contact Information</h3>
                            <p><strong>Address:</strong> Coming soon in Sarajevo!</p>
                            <p><strong>Phone:</strong> +38712 345 678</p>
                            <p><strong>Email:</strong> avdo.sator@hotmail.com</p>
                            <p><strong>LinkedIn: </strong><a href="https://www.linkedin.com/in/avdo-%C5%A1ator-725370308/">Avdo Sator</a></p>
                        </div>
                        <div className="col-md-6">
                            <h3 className="mb-5">Send us a message</h3>
                            <form>
                                <div className="mb-3">
                                    <label htmlFor="contactPageName" className="form-label fw-medium">Username</label>
                                    <Input type="text" className="form-control contact-form-control" value={2 } id="contactPageName" name="contactPageName"
                                        onChange={ } placeholder="Enter your username" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="contactPageEmail" className="form-label fw-medium">Email</label>
                                    <Input type="email" className="form-control contact-form-control" value={2 } id="contactPageEmail" name="contactPageEmail"
                                        onChange={ } placeholder="Enter your email" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="contact-page-message" className="form-label fw-medium">Message</label>
                                    <textarea className="form-control contact-form-control" id="contact-page-message" rows={4} placeholder="Your Message"></textarea>
                                </div>
                                <button type="submit" className="btn btn-primary contact-form-button">Send</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}