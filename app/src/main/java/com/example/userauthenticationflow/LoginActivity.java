package com.example.userauthenticationflow;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Patterns;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

TextView registerButton;
Button LogInButton;
EditText Email, Password;
private  String retrievedEmail ,  retrievedPassword , retrivedName , retrivedMobileNO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();
        retrieveDataFromRegisterActivityAndLogin();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(LoginActivity.this,Register_activity.class);
                startActivity(register);
            }
        });


        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = Email.getText().toString().trim();
                String enteredPassword = Password.getText().toString().trim();

                if (isValidCredentials(enteredEmail, enteredPassword)) {
                    if (enteredEmail.equals(retrievedEmail) && enteredPassword.equals(retrievedPassword)) {
                        // Successful login
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                        gotoUserProfile();

                    } else {
                        // Failed login
                        Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void gotoUserProfile() {

        Intent userprofile = new Intent(getApplicationContext(),UserProfile.class);

        //send data to login
        Bundle bundle = new Bundle();
        bundle.putString("name", retrivedName);
        bundle.putString("mobileNo", retrivedMobileNO);
        bundle.putString("email", retrievedEmail);

        userprofile.putExtras(bundle);

        startActivity(userprofile);
    }

    private void initializeViews() {

        registerButton=findViewById(R.id.register_button);
        LogInButton = findViewById(R.id.Login_Button);

        Email = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.editTextPassword);

        LogInButton.setTextColor(getColor(R.color.white));
        LogInButton.setTypeface(null, Typeface.BOLD);

    }

    private void retrieveDataFromRegisterActivityAndLogin() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            retrievedEmail = extras.getString("email");
            retrievedPassword = extras.getString("password");
            retrivedName = extras.getString("name");
            retrivedMobileNO = extras.getString("mobileNo");

            // You can now use the email and password for login purposes
//            Toast.makeText(this, "Email: " + retrievedEmail + ", Password: " + retrievedPassword , Toast.LENGTH_SHORT).show();

        }
    }

    private boolean isValidCredentials(String email, String password) {
        if (!isValidEmail(email)) {
            Email.setError("Enter a valid email address");
            return false;
        }

        if (!isValidPassword(password)) {
            Password.setError("Password must be at least 6 characters long");
            return false;
        }

        return true;
    }

    private boolean isValidEmail(CharSequence target) {
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private boolean isValidPassword(CharSequence target) {
        return target != null && target.length() >= 6;
    }
}