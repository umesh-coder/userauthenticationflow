package com.example.userauthenticationflow;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register_activity extends AppCompatActivity {

    EditText name,mobileNo,email,password;
    TextView signInButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeViews();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateInput()) {
//                    Log.d("Data", "Name:- "+name.getText().toString()+"mobiile no:"+mobileNo.getText().toString()+"Email:"+email.getText().toString()+"password:"+password.getText().toString());
                    Toast.makeText(getApplicationContext(), "Registration Successful.", Toast.LENGTH_LONG).show();
                    gotologin();

                }
            }



        });



        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotologin();
            }
        });

    }

    private void gotologin() {
        Intent login = new Intent(getApplicationContext(),LoginActivity.class);

        //send data to login
        Bundle bundle = new Bundle();
        bundle.putString("name", name.getText().toString());
        bundle.putString("mobileNo", mobileNo.getText().toString());
        bundle.putString("email", email.getText().toString());
        bundle.putString("password",password.getText().toString());
        login.putExtras(bundle);

        startActivity(login);
    }




    private void initializeViews() {
        name=findViewById(R.id.editTextName);
        mobileNo=findViewById(R.id.editTextMobile);
        email=findViewById(R.id.editTextEmail);
        password=findViewById(R.id.editTextPassword);

        registerButton=findViewById(R.id.Register_Button);
        signInButton=findViewById(R.id.signin_button);



        registerButton.setTextColor(getColor(R.color.white));
        registerButton.setTypeface(null, Typeface.BOLD);

    }

    private boolean validateInput() {
        boolean isValid = true;

        // Check if name is empty or contains non-alphabetic characters
        if(name.getText().toString().isEmpty() || !name.getText().toString().matches("[a-zA-Z]+")) {
            name.setError("Please enter a valid name");
            isValid = false;
        }

        // Check if mobile number is empty or not 10 digits
        if(mobileNo.getText().toString().isEmpty() || mobileNo.getText().toString().length() != 10) {
            mobileNo.setError("Please enter a valid 10-digit mobile number");
            isValid = false;
        }

        // Check if email is empty or not valid
        if(email.getText().toString().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            email.setError("Please enter a valid email address");
            isValid = false;
        }

        // Check if password is empty or less than 6 characters
        if(password.getText().toString().isEmpty() || password.getText().toString().length() < 6) {
            password.setError("Password must be at least 6 characters long");
            isValid = false;
        }

        return isValid;
    }
}