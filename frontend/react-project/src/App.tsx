
import { useEffect, useState } from 'react'
import './App.css'
import Navbar from './header-footer/Navbar'
import Topbar from './header-footer/Topbar'
import Footer from './header-footer/Footer'

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
			<h1>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet nihil unde, minus a in at aperiam obcaecati praesentium asperiores, tempora beatae culpa, voluptate veniam eligendi ad. Tenetur unde consequatur quasi.
			Excepturi dignissimos tempora laudantium natus fuga iste, repudiandae, temporibus eaque nulla laboriosam consectetur est debitis sed aperiam facilis! Repellendus eius ipsam fugiat obcaecati, iusto quia ab repellat perferendis officiis aspernatur.
			Praesentium architecto corporis rem aut recusandae esse enim reiciendis, tempore quaerat itaque in, at et veritatis maxime expedita culpa possimus iusto, ut odit magni molestiae voluptate dignissimos saepe. Laborum, voluptatem!
			Omnis est excepturi vitae voluptate harum, ducimus molestiae explicabo. Beatae illo aliquam harum obcaecati, corporis ipsam dolor, necessitatibus dignissimos consequatur laborum aliquid. Aperiam beatae vel culpa est quae, doloribus tenetur?
			Cum, ipsa vel ratione voluptatum voluptate labore perferendis corporis praesentium, impedit laborum aut quas unde in, est quidem saepe iusto velit totam rem illo at soluta illum odit adipisci? Reiciendis.</h1>
			<Footer />
		</>
	)
}

export default App
