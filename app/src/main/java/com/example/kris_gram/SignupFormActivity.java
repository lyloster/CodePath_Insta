package com.example.kris_gram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupFormActivity extends AppCompatActivity {

    public static final String TAG = "SignupFormActivity";
    private EditText etNewUser;
    private EditText etNewUserPassword;
    private Button btnCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        etNewUser = findViewById(R.id.etNewUser);
        etNewUserPassword = findViewById(R.id.etNewUserPassword);
        btnCreateUser = findViewById(R.id.btnCreateUser);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etNewUser.getText().toString();
                String password = etNewUserPassword.getText().toString();
                if (username.isEmpty()) {
                    Toast.makeText(SignupFormActivity.this, "Username cannot be empty", Toast.LENGTH_LONG).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(SignupFormActivity.this, "Password cannot be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                createUser(username,password);


            }
        });
    }

    private void goLoginActivity() {
        Intent i = new Intent(SignupFormActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void createUser(String username, String password) {
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(SignupFormActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Issue with creating user", e);
                    return;
                }

                Toast.makeText(SignupFormActivity.this, "User created!", Toast.LENGTH_LONG).show();
                goLoginActivity();

            }
        });
    }
}