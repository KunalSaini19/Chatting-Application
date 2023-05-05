package com.kunalsaini.chitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText firstNameText;
    private EditText lastNameText;
    private EditText phoneText;
    private EditText emailText;
    private EditText passwordText;

    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        firstNameText = findViewById(R.id.signup_firstname);
        lastNameText = findViewById(R.id.signup_lastname);
        phoneText = findViewById(R.id.signup_phone);
        emailText = findViewById(R.id.signup_email);
        passwordText = findViewById(R.id.signup_password);

        signupButton = findViewById(R.id.signup_signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstName = firstNameText.getText().toString().trim();
                final String lastName = lastNameText.getText().toString().trim();
                final String phone = phoneText.getText().toString().trim();
                final String email = emailText.getText().toString().trim();
                String password = passwordText.getText().toString().trim();

                if(firstName.isEmpty())
                {
                    firstNameText.setError("First Name is required...");
                    return;
                }
                if(lastName.isEmpty())
                {
                    lastNameText.setError("Last Name is required...");
                    return;
                }
                if(phone.isEmpty() || phone.length() != 10)
                {
                    phoneText.setError("Invalid phone number...");
                    return;
                }
                if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    emailText.setError("Invalid Email...");
                    return;
                }
                if(password.isEmpty() || password.length() < 8)
                {
                    passwordText.setError("Password is too short...");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    String uid = FirebaseAuth.getInstance().getUid();
                                    String deviceToken = FirebaseMessaging.getInstance().getToken().toString();

                                    DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("Users")
                                            .child(uid);

                                    userReference.child("firstName").setValue(firstName);
                                    userReference.child("lastName").setValue(lastName);
                                    userReference.child("fullName").setValue(firstName + " " + lastName);
                                    userReference.child("phone").setValue(phone);
                                    userReference.child("email").setValue(email);
                                    userReference.child("uid").setValue(uid);
                                    userReference.child("profileExist").setValue("0");
                                    userReference.child("phoneVerified").setValue("0");
                                    userReference.child("emailVerified").setValue("0");
                                    userReference.child("deviceToken").setValue(deviceToken);

                                    Intent loginIntent = new Intent(SignupActivity.this, DrawerActivity.class);
                                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(loginIntent);
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(SignupActivity.this,
                                            task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}