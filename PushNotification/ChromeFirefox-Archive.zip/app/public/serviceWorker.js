
// Push notifications actions
function onPushNotificationReceived(event) {
    if (event.data) {
        console.log('Event data is : ', event.data.text());
        var messageJson = event.data.json();
        var title = messageJson.title ? messageJson.title : "New message";
        var bodyAlert = messageJson.alert ? messageJson.alert : "Example message"
        self.registration.showNotification(title, {
            body: bodyAlert,
        }); 
    } else {
        console.log('Push notification received without data: ', event);
    }
}

// Event Listners 

self.addEventListener('push', onPushNotificationReceived);


self.addEventListener('install', function (event) {
    console.log('Installed Service Worker : ', event);
});


self.addEventListener('activate', function (event) {
    console.log('Activated Service Worker : ', event);
});