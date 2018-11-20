package com.example.android.sharedprefsloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;
    private EditText userName, userPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        userName = findViewById(R.id.user_name);
        userPassword = findViewById(R.id.user_password);

        if (preferenceConfig.readLoginStatus()) {
            startActivity(new Intent(this, SuccessActivity.class));
            finish();
        }


    }

    public void loginUser(View view) {

        String username = userName.getText().toString();
        String userpassword = userPassword.getText().toString();


        if (username.equals(getResources().getString(R.string.user_name)) && userpassword.equals(getResources().getString(R.string.user_password))) {
            startActivity(new Intent(this, SuccessActivity.class));
            preferenceConfig.writeLoginStatus(true);
            finish();
        } else {
            Toast.makeText(this, "Login Failed Please Try again", Toast.LENGTH_SHORT).show();
            userName.setText("");
            userPassword.setText("");
        }

    }
}
