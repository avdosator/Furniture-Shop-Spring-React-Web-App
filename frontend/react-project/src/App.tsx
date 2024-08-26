import './App.css'
import Navbar from './header-footer/Navbar'
import Topbar from './header-footer/Topbar'
import Footer from './header-footer/Footer'
import HomePage from './layouts/HomePage/HomePage'
import Contact from './layouts/ContactPage/ContactPage'
import AboutPage from './layouts/AboutPage/AboutPage'
import { Route, Routes } from 'react-router-dom'
import ProductRoutes from './routes/ProductRoutes'
import LoginForm from './layouts/LoginPage/LoginForm'
import SignupForm from './layouts/SignupPage/SignupForm'


function App() {

	return (
		<>
			<Topbar />
			<Navbar />
			<Routes>
				<Route path='/' element={<HomePage />} />
				<Route path='/home' element={<HomePage />} />
				<Route path='/about' element={<AboutPage />} />
				<Route path='/products/*' element={<ProductRoutes />} />
				<Route path='/latest' element={<h1>Placeholder for "latest" page</h1>} />
				<Route path='/contact' element={<Contact />} />
				<Route path='/login' element={<LoginForm />} />
				<Route path='/signup' element={<SignupForm />} />
				<Route path='*' element={<h1>Placeholder for 404 page</h1>} />
			</Routes>
			<Footer />
		</>
	);
}

export default App
