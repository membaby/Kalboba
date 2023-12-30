export default async function makeRequest(endpoint, method, body=null) {
    let url = `http://localhost:8080/${endpoint}`;

    return fetch(url, { method: method, body: body,
    headers: {
        'Content-Type': 'application/json',
    } })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .catch(error => {
            console.error("Error fetching doctors list:", error);
            throw new Error("Error fetching doctors list.");
    });
}  