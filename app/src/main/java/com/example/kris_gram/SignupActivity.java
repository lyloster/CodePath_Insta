package com.example.kris_gram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.SplittableRandom;

public class SignupActivity extends AppCompatActivity {

    public final String TAG = "SignupActivity";
    Button btnSignup;
    Button btnLoginSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = findViewById(R.id.btnSignup);
        btnLoginSignup = findViewById(R.id.btnLogin_Signup);

        btnLoginSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this, SignupFormActivity.class);
                startActivity(i);
                finish();
            }
        });

        if (ParseUser.getCurrentUser() != null) {
            goMainActivity();
        }
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}