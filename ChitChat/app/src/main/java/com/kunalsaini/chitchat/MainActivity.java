package com.kunalsaini.chitchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private Button signupButton;

    private static boolean firstLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(firstLaunch == true)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            firstLaunch = false;
        }

        loginButton = findViewById(R.id.main_sign_in_btn);
        signupButton = findViewById(R.id.main_sign_up_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(signupIntent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            FirebaseAuth.getInstance().getCurrentUser().reload();
            if (FirebaseAuth.getInstance().getCurrentUser().isEmailVerified())
            {
                Intent drawerIntent = new Intent(MainActivity.this, DrawerActivity.class);
                drawerIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(drawerIntent);
                finish();
            }
            else
            {
                FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification();
                Intent emailVerificationIntent = new Intent(MainActivity.this, EmailVerificationActivity.class);
                emailVerificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(emailVerificationIntent);
                finish();
            }
        }
    }
}