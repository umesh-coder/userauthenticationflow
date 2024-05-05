package com.example.userauthenticationflow;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register_activity extends AppCompatActivity {

    EditText name,mobileNo,email,password;

    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeViews();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Data", "Name:- "+name.getText().toString()+"mobiile no:"+mobileNo.getText().toString()+"Email:"+email.getText().toString()+"password:"+password.getText().toString());

                Toast.makeText(getApplicationContext(),"Name:- "+name.getText().toString()+"mobiile no:"+mobileNo.getText().toString()+"Email:"+email.getText().toString()+"password:"+password.getText().toString() ,Toast.LENGTH_LONG).show();

            }
        });


    }

    private void initializeViews() {
        name=findViewById(R.id.editTextName);
        mobileNo=findViewById(R.id.editTextMobile);
        email=findViewById(R.id.editTextEmail);
        password=findViewById(R.id.editTextPassword);

        registerButton=findViewById(R.id.Register_Button);
    }
}