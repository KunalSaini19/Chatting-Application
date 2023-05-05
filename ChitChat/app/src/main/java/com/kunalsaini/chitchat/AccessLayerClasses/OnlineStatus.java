package com.kunalsaini.chitchat.AccessLayerClasses;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineStatus {
    public static void setOnlineTime()
    {


        final DatabaseReference OnlineStatusRef = FirebaseDatabase.getInstance().getReference("OnlineStatus")
                .child(FirebaseAuth.getInstance().getUid()).child("timeStamp");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                OnlineStatusRef.setValue(timeStamp);
            }
        }, 0, 2000);
    }
}
