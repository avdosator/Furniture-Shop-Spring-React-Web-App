
import { useEffect, useState } from 'react'
import './App.css'
import Navbar from './header-footer/Navbar'
import Topbar from './header-footer/Topbar'
import Footer from './header-footer/Footer'
import HomePage from './layouts/HomePage/HomePage'
import Contact from './layouts/ContactPage/ContactPage'
import AboutPage from './layouts/AboutPage/AboutPage'

type ResponseType = {
	message: string
}

function App() {
	// let [responseMessage, setResponseMessage] = useState<ResponseType | null>(null);

	// useEffect(() => {
	// 	const connect = async () => {
	// 		try {
	// 			const response = await fetch("http://localhost:8080/test");
	// 			if (!response.ok) throw new Error("Could not get the data!");
	// 			const resJson = await response.json();
	// 			setResponseMessage(resJson);
	// 		} catch (error) {
	// 			setResponseMessage({message: `${error}`});
	// 		}
	// 	}
	// 	connect();
	// }, [])
	return (
		<>	
			<Topbar />
			<Navbar />
			<HomePage />
			<Contact />
			<AboutPage />
			<Footer />
		</>
	)
}

export default App
