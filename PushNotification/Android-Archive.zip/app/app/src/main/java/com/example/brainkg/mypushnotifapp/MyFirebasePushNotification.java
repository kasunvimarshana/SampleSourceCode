package com.example.brainkg.mypushnotifapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class MyFirebasePushNotification extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Map<String, String> data = remoteMessage.getData();
        JSONObject dataPayload = new JSONObject(data);

        Log.d("Data Message", dataPayload.toString());

        try {

            buildNotifications(dataPayload);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void buildNotifications(JSONObject dataPayload) throws JSONException {

        String NOTIF_CHANNEL = "MY_CHANNEL_01";

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(NOTIF_CHANNEL, "My Notif Channel", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableLights(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIF_CHANNEL);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("This is the title")
                .setContentText(dataPayload.getString("message"));

        notificationManager.notify(1, notificationBuilder.build());

    }
}
