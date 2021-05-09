package com.joemarini.fcmexample;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FCMExampleMsgService extends FirebaseMessagingService {
    private static final String TAG = "FCMExampleMsgService";


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived: Msg received from " + remoteMessage.getFrom());
        
        if(remoteMessage.getData().size() > 0) {
            Log.d(TAG, "onMessageReceived: Data size is " + remoteMessage.getData().size());
            for(String key: remoteMessage.getData().keySet()) {
                Log.d(TAG, "onMessageReceived: Key: " + key + ", value: " + remoteMessage.getData().get(key));
            }
        }
    }
}
