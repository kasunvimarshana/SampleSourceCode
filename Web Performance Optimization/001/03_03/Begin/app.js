function perf(type, name, data) {
    //TODO: send the data to the server
    console.log(`%c${type}: %c${name} | %c${data?Math.round(data)+'ms':''}`, "color: red",
                "color: green", "color: gray");
}

window.addEventListener("load", () => {
    const navEntries = performance.getEntriesByType("navigation");
    navEntries.forEach( entry => {
        perf("navigation", "fetch-start", entry.fetchStart);
        const ttfb = entry.responseStart-entry.fetchStart;
        perf("navigation", "ttfb", ttfb);
    });
    if (navEntries.length==0) {
        // old version
        perf("navigation", "fetch-start", performance.timing.fetchStart);
        const ttfb = performance.timing.responseStart-performance.timing.fetchStart;
        perf("navigation", "ttfb", ttfb);
    }
});