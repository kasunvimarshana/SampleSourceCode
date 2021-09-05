if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register("serviceworker.js");
    navigator.serviceWorker.addEventListener("message", event => {
        switch (event.data.action) {
            case "resources-updated":
                alert("The app is ready for an update. Please reload");
                break;
        }
    });
}



function sendMessageToSW(message) {
    if (navigator.serviceWorker.controller) {
        navigator.serviceWorker.controller.postMessage(message);
    } else {
        console.log("There is no SW controlling this page");
    }
}

function update() {
    sendMessageToSW({
        action: "update-resources"
    });
}