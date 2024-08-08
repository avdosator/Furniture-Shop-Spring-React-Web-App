import "./AboutPage.css"

export default function AboutPage() {
    return (
        <div className="about-page">
            <div className="full-screen-section d-flex justify-content-center align-items-center text-center">
                <div className="overlay">
                    <h1 className="display-4 mb-0 mb-lg-5">About F Store</h1>
                    <p className="lead mx-auto mt-5">
                        F Store is your one-stop shop for all your needs. We provide high-quality products at competitive prices.
                        Our mission is to deliver exceptional value and service to our customers.
                        <span className="spacer"></span>
                        At F Store, we believe in offering a diverse range of products to cater to all your preferences and needs.
                        Whether you're looking for the latest gadgets, fashion trends, home essentials, or unique gifts, we have it
                        all under one roof. Our dedicated team works tirelessly to ensure that every product meets our stringent
                        quality standards, so you can shop with confidence.
                        <span className="spacer"></span>
                        Experience the convenience of online shopping with F Store, where customer satisfaction is our top priority.
                    </p>
                </div>
            </div>
            <div className="dark-section py-5 text-center">
                <h1 className="display-4 mb-0 mb-lg-5 mt-5 mt-lg-0">Our Story</h1>
                <p className="lead mx-auto mt-5">
                    Founded in 2021, F Store started with a small group of passionate individuals committed to providing the best
                    shopping experience. Over the years, we have grown into a beloved brand with a wide range of products and a
                    dedicated customer base.
                    <span className="spacer"></span>
                    Our journey began with a simple idea: to make shopping more accessible and enjoyable for everyone. We have 
                    since expanded our offerings, constantly innovating and adapting to the latest market trends to ensure that our 
                    customers always find what they are looking for.
                    <span className="spacer"></span>
                    From humble beginnings to becoming a household name, F Store's success is built on the trust and loyalty of 
                    our customers. Join us as we continue to grow and evolve, bringing you the best in retail every day.
                </p>
            </div>
        </div>
    )
}