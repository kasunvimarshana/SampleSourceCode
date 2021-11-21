function perf(type, name, data) {
    //TODO: send the data to the server
    console.log(`%c${type}: %c${name} | %c${data?data:''}`, "color: red",
                "color: green", "color: silver");
}

window.addEventListener("load", () => {
    perf("onload", "event");
});