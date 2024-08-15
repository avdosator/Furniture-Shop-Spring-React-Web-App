
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
				<Route path='/products'>
					<Route index element={<h1>Placeholder for "products" page</h1>} />
					<Route path=':id' element={<h1>Placeholder for single product page</h1>} />
					<Route path='new' element={<h1>Placeholder for adding new product</h1>} />
				</Route>
				<Route path='/latest' element={<h1>Placeholder for "latest" page</h1>} />
				<Route path='/contact' element={<Contact />} />
				<Route path='/login' element={<h1>Placeholder for "login" page</h1>} />
				<Route path='/signup' element={<h1>Placeholder for "sign up" page</h1>} />
			</Routes>
			<Footer />
		</>
	);
}

export default App
