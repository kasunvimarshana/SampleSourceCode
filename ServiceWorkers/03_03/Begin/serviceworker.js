// version 3
try {
    importScripts("events.js");
} catch (e) { }

self.addEventListener("fetch", event => {
    console.log(`Fetching ${event.request.url}`);
    const response = new Response(`The URL is ${event.request.url}`);
    event.respondWith(response);
});