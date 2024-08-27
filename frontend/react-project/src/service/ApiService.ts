export default class ApiService {

    static async call<T>(route: string, method: string = "GET", body: Object = {}, headers: Record<string, string> = {}): Promise<T> {
        const options: RequestInit = {
            method: method,
            headers: {
                "Content-Type": "application/json",
                ...headers
            }
        }

        if (body) options.body = JSON.stringify(body);

        try {
            const response = await fetch(`http://localhost:8080/${route}`, options);
            if (!response.ok) throw new Error(response.statusText);
            const data: T = await response.json();
            return data;
        } catch (error) {
            console.error("Api call failed ", error);
            throw error;
        }
    }
}