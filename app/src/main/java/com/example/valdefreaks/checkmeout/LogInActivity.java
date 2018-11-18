package com.example.valdefreaks.checkmeout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {

    EditText et_log_in_user;
    EditText et_log_in_password;
    TextView tv_log_in_registration;
    Button btn_log_in_log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        et_log_in_user = findViewById(R.id.et_log_in_user);
        et_log_in_password = findViewById(R.id.et_log_in_password);
        tv_log_in_registration = findViewById(R.id.tv_log_in_registration);
        btn_log_in_log_in = findViewById(R.id.btn_log_in_log_in);

        btn_log_in_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainActivity = new Intent(LogInActivity.this,MainActivity.class);
                startActivity(intentMainActivity);
            }
        });

        tv_log_in_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistration = new Intent(LogInActivity.this,RegistrationActivity.class);
                startActivity(intentRegistration);
            }
        });
    }



}
