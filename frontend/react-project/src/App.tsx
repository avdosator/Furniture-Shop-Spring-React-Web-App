
import { useEffect, useState } from 'react'
import './App.css'

type ResponseType = {
	message: string
}

function App() {
	let [responseMessage, setResponseMessage] = useState<ResponseType | null>(null);

	useEffect(() => {
		const connect = async () => {
			try {
				const response = await fetch("http://localhost:8080/test");
				if (!response.ok) throw new Error("Could not get the data!");
				const resJson = await response.json();
				setResponseMessage(resJson);
			} catch (error) {
				setResponseMessage({message: `${error}`});
			}
		}
		connect();
	}, [])
	return (
		<>
			<h1>{responseMessage?.message}</h1>
		</>
	)
}

export default App
