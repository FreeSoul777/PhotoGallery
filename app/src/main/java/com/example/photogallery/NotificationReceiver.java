package com.example.photogallery;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationManagerCompat;

import java.io.InputStream;

public class NotificationReceiver extends BroadcastReceiver {

    private static final String TAG = "NotificationReceiver";

    @Override
    public void onReceive(Context context, Intent i) {
        Log.i(TAG, "received result: " + getResultCode());
        if(getResultCode() != Activity.RESULT_OK) {
            return;
        }

        int requestCode = i.getIntExtra(PollService.REQUEST_CODE, 0);
        Notification notification = (Notification) i.getParcelableExtra(PollService.NOTIFICATION);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(PollService.MY_NOTIFY, PollService.MY_NOTIFY,
                            NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(requestCode, notification);
    }
}
