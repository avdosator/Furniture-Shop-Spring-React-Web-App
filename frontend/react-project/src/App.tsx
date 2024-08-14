
import { useEffect, useState } from 'react'
import './App.css'
import Navbar from './header-footer/Navbar'
import Topbar from './header-footer/Topbar'
import Footer from './header-footer/Footer'
import HomePage from './layouts/HomePage/HomePage'
import Contact from './layouts/ContactPage/ContactPage'
import AboutPage from './layouts/AboutPage/AboutPage'
import { Route, Routes } from 'react-router-dom'

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
			<Routes>
				<Route path='/' element={<HomePage />} />
				<Route path='/home' element={<HomePage />} />
				<Route path='/about' element={<AboutPage />} />
				<Route path='/contact' element={<Contact />} />
			</Routes>
			<Footer />
		</>
	)
}

export default App
