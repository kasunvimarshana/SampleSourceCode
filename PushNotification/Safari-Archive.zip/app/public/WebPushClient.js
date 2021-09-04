
function WebPushClient() {
 
  var checkRemotePermission = function (permissionData) {

    if (permissionData.permission === 'default') {
      
      window.safari.pushNotification.requestPermission(
        'Your Website Address',
        'Safari Web push ID',
        {},
        checkRemotePermission
      );
    }
    else if (permissionData.permission === 'denied') {
      // The user said no.
      console.dir(arguments);
    }
    else if (permissionData.permission === 'granted') {
      console.log("The user said yes, with token: " + permissionData.deviceToken);
      alert(permissionData.deviceToken)
    }
  }
    

  this.register = function() {

    if ('safari' in window && 'pushNotification' in window.safari) {
          
      var permissionData = window.safari.pushNotification.permission('Safari Web push ID');
      checkRemotePermission(permissionData);
     } else {
         alert("Push notifications not supported.");
    }
  };

}