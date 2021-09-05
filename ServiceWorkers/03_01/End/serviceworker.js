// version 3
try {
    importScripts("events.js");
} catch (e) { }

self.addEventListener("fetch", event => {
    console.log(`Fetching ${event.request.url}`);
});