package com.BluesToos.VirtC;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.BluesToos.vc.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {


    //This handles recieving the data for a notification while the app is opened
    public static int NOTIFICATION_ID = 1;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("MRECIEVED","ONTO GENERATE  NOT");

        //if(remoteMessage.getData().size() > 0){
        Log.d("DATA","GETTING DATA");
        String titlem = remoteMessage.getNotification().getTitle();
        String messagem = remoteMessage.getNotification().getBody();
        notifications.titles.add(titlem);
        notifications.messages.add(messagem);
        Log.d("title","title" + titlem);
        Log.d("message","message" + messagem);
        Intent intent = new Intent("edu.fandm.pweiser.notes_FCMMESSAGE");
        intent.putExtra("title",titlem);
        intent.putExtra("message",messagem);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.sendBroadcast(intent);
        //OnCreate();

        //}
        generateNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());


    }

    //This displays the notification
    private void generateNotification(String body, String title) {
        Log.d("generateNotification","GENERATING NOTE");
        Intent intent = new Intent(this,notifications.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        if(NOTIFICATION_ID > 1073741824){
            NOTIFICATION_ID = 0;
        }

        notificationManager.notify(NOTIFICATION_ID++, notificationBuilder.build());


    }

}