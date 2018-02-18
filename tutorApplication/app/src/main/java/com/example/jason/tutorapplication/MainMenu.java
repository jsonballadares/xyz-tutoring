package com.example.jason.tutorapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent intentData = getIntent();
        String email = intentData.getStringExtra("email");

        //mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //editor = mPreferences.edit();

        Toast toast = Toast.makeText(MainMenu.this,"Welcome " + email , Toast.LENGTH_SHORT);
        toast.show();


    }


}
