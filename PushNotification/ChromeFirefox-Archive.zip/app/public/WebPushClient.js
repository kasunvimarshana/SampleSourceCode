
// Script to register for push notifications
function WebPushClient() {


  const SERVICE_WORKER = 'serviceWorker.js';

  // Function to Display the token values (Reg details)
  function displayToken(token) {

    console.log('Token value is : ', JSON.stringify(token));
    alert('The token is : ' + JSON.stringify(token));

    var rawKey = token.getKey ? token.getKey('p256dh') : '';
    var key = rawKey ? btoa(String.fromCharCode.apply(null, new Uint8Array(rawKey))) : '';
    var rawAuthSecret = token.getKey ? token.getKey('auth') : '';
    var authSecret = rawAuthSecret ? btoa(String.fromCharCode.apply(null, new Uint8Array(rawAuthSecret))) : '';

    console.log(key, authSecret);
  }


  // Register Service worker
  function checkNotificationSupport() {

    return new Promise((resolve, reject) => {

      console.log("Started checking the notification compatibility");

      if (navigator.serviceWorker &&
        window.location.protocol === 'https:') { //Only HTTPS is supported


        navigator.serviceWorker.register(SERVICE_WORKER).then(function (reg) {

          if (reg.installing) {
            console.log('Service worker installing');
          } else if (reg.waiting) {
            console.log('Service worker installed');
          } else if (reg.active) {
            console.log('Service worker active');
          }
          if (!(reg.showNotification)) {
            reject({
              response: "Notifications aren\'t supported on service workers.",
              statusCode: 401, error: "Error"
            });
          }

          // Check the current Notification permission.
          // If its denied, it's a permanent block until the
          // user changes the permission
          if (Notification.permission === 'denied') {
            console.log('The user has blocked notifications.');
            reject({ response: "The user has blocked notifications", statusCode: 401, error: "Error" });
          }

          // Check if push messaging is supported
          if (!('PushManager' in window)) {
            console.log('Push messaging isn\'t supported.');
            reject({ response: "Push messaging isn\'t supported.", statusCode: 401, error: "Error" });
          }
          resolve();
        });

      } else {
        console.log('Service workers aren\'t supported in this browser.');
        reject({ response: "Service workers aren\'t supported in this browser.", statusCode: 401, error: "Error" });
      }
    });
  }

  // Register call functions
  this.register = function (callback) {

    //Chrome and Firefox
    if (checkNotificationSupport()) {

      navigator.serviceWorker.ready.then(function (reg) {

        reg.pushManager.getSubscription().then(

          function (subscription) {

            if (subscription) {

              displayToken(subscription);
              let res = {
                response: "Success : subscription is " + subscription,
                error: "",
                statusCode: 200
              }
              callback(res)

            } else {

              reg.pushManager.subscribe({

                userVisibleOnly: true

              }).then(function (subscription) {

                displayToken(subscription);
                let res = {
                  response: "Success : subscription is " + subscription,
                  error: "",
                  statusCode: 200
                }
                callback(res)

              }).catch(function (error) {

                if (Notification.permission === 'denied') {

                  // The user denied the notification permission which
                  // means we failed to subscribe and the user will need
                  // to manually change the notification permission to
                  // subscribe to push messages
                  console.log('Permission for Notifications was denied');
                  let res = {
                    response: "",
                    error: "Permission for Notifications was denied",
                    statusCode: 401
                  };
                  callback(res)

                } else {
                  // A problem occurred with the subscription, this can
                  // often be down to an issue or lack of the gcm_sender_id
                  // and / or gcm_user_visible_only

                  console.log('Unable to subscribe to push.', error);
                  let res = {
                    response: "",
                    error: "Unable to subscribe to push : " + error,
                    statusCode: 401
                  };
                  callback(res)
                }
              });
            }
          }).catch(function (e) {

            console.log('Error thrown while subscribing from ' +
              'push messaging.', e);
            let res = {
              response: "",
              error: "Error thrown while subscribing from push messaging : " + e,
              statusCode: 401
            };
            callback(res)
          });
      });
    }
  };


 
}
