// version 3
try {
    importScripts("events.js");
} catch (e) { }

self.addEventListener("fetch", event => {
    console.log(`Fetching ${event.request.url}`);
    const body = `
        <!doctype html>
        <title>Service Worker HTML generation</title>
        <h1>
        The URL is ${event.request.url}
        </h1>
        <ul>
            <li>Cache: ${event.request.cache}</li>
            <li>Credentials: ${event.request.credential}</li>
            <li>Destination: ${event.request.destination}</li>
            <li>Method: ${event.request.method}</li>
            <li>Referrer: ${event.request.referrer}</li>
        </ul>
    `;
    const response = new Response(body,
    {
        status: 200,
        statusText: "OK",
        headers: {
            "Content-type": "text/html"
        }
    });
    event.respondWith(response);
});