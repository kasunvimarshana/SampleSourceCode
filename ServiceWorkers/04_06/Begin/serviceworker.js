const precacheList = [
    "/", "mission.html", "resources.html", "tours.html", 
    "app.js", "weather.js",
    "_css/fonts.css", "_css/main.css", "_css/mobile.css", "_css/tablet.css",
    "_images/back_bug.gif", "_images/desert_desc_bug.gif", "_images/nature_desc_bug.gif",
    "_images/backpack_bug.gif", "_images/flag.jpg", "_images/snow_desc_bug.gif",
    "_images/calm_bug.gif", "_images/home_page_back.jpg","_images/springs_desc_bug.gif",
    "_images/calm_desc_bug.gif", "_images/kids_desc_bug.gif", "_images/star_bullet.gif",
    "_images/cycle_desc_bug.gif", "_images/logo.gif", "_images/taste_bug.gif",
    "_images/cycle_logo.png", "_images/looking.jpg", "_images/taste_desc_bug.gif",
    "_images/desert_bug.gif", "_images/mission_look.jpg", "_images/tour_badge.png"
];

self.addEventListener("install", event => {
    event.waitUntil(
        caches.open("california-assets-v1")
            .then( cache => {
                cache.addAll(precacheList);
            }
        )
    );
});

// Cache-first policy
self.addEventListener("fetch", event => {
    event.respondWith(
        caches.match(event.request)
            .then( response => {
                if (response) {
                    return response; // The URL is cached
                } else {
                    return fetch(event.request); // Go to the network
                }
            })
    );
})