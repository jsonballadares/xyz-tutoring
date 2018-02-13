package com.example.jason.tutorapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Toast toast = Toast.makeText(RegistrationActivity.this,"Welcome to XYZ!",Toast.LENGTH_SHORT);
        toast.show();

    }
}
