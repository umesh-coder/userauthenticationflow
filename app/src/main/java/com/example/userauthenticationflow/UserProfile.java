package com.example.userauthenticationflow;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserProfile extends AppCompatActivity {

    private  String retrievedEmail , retrivedName , retrivedMobileNo;
    EditText name,mobileNo,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        initializeViews();
        retrieveDataFromRegisterActivity();
        setfliedtext();

    }

    private void setfliedtext() {
        name.setText(retrivedName);
        name.setTextColor(getColor(R.color.white));


        email.setText(retrievedEmail);
        email.setTextColor(getColor(R.color.white));


        mobileNo.setText(retrivedMobileNo);
        mobileNo.setTextColor(getColor(R.color.white));

    }

    private void initializeViews() {
        name=findViewById(R.id.User_nameEditText);
        email=findViewById(R.id.User_email_EditText);
        mobileNo=findViewById(R.id.User_mobileNoEditText);

    }

    private void retrieveDataFromRegisterActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            retrievedEmail = extras.getString("email");
            retrivedName = extras.getString("name");
            retrivedMobileNo = extras.getString("mobileNo");

            // You can now use the email and password for login purposes
//            Toast.makeText(this, "Email: " + retrievedEmail + ", Password: " + retrivedName , Toast.LENGTH_SHORT).show();

        }
    }
}