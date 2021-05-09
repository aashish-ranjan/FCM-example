package com.joemarini.fcmexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "FCMExample: ";

    private String m_FCMtoken;
    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: get the FCM instance default token

        tvMsg = (TextView)findViewById(R.id.textView2);
        m_FCMtoken = FirebaseInstanceId.getInstance().getToken();

        // TODO: Log the token to debug output so we can copy it
        ((Button)findViewById(R.id.btnLogToken)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: FCM token is " + m_FCMtoken);
            }
        });

        // TODO: subscribe to a topic
        ((Button)findViewById(R.id.btnSubscribe)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        // TODO: unsubscribe from a topic
        ((Button)findViewById(R.id.btnUnsubscribe)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        // TODO: When the activity starts up, look for intent information
        // that may have been passed in from the Notification tap
        if (getIntent().getExtras() != null) {
            StringBuilder launchMsg = new StringBuilder();
            for(String key: getIntent().getExtras().keySet()) {
                Object val = getIntent().getExtras().get(key);
                Log.d(TAG, "onCreate: key= " + key + " ,value = " + val + "\n");
                launchMsg.append("key= " + key + " ,value = " + val + "\n");
            }
            tvMsg.setText(launchMsg);
        }
        else {
            tvMsg.setText("No launch information");
        }
    }

}
