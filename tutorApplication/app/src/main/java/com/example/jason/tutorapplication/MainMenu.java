package com.example.jason.tutorapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

    //todo maybe use this for more functionality
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor editor;

    private CardView scheduleCard, classCard, videoCard, exerciseCard, profileCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //defining cards
        scheduleCard = findViewById(R.id.scheduleCard);
        classCard = findViewById(R.id.classCard);
        videoCard = findViewById(R.id.videoCard);
        exerciseCard = findViewById(R.id.exerciseCard);
        profileCard = findViewById(R.id.profileCard);

        //adding  listener
        scheduleCard.setOnClickListener(this);
        classCard.setOnClickListener(this);
        videoCard.setOnClickListener(this);
        exerciseCard.setOnClickListener(this);
        profileCard.setOnClickListener(this);

        //gets intent that is sent to it
        //this is where the data is transfered
        Intent intentData = getIntent();
        String email = intentData.getStringExtra("email");


        //toasts the user
        Toast toast = Toast.makeText(MainMenu.this,"Welcome " + email , Toast.LENGTH_SHORT);
        toast.show();

    }


    @Override
    public void onClick(View view) {

        Intent i;

        switch(view.getId()){

            case R.id.scheduleCard : i = new Intent(this,ScheduleActivity.class);startActivity(i);break;
            case R.id.classCard : i = new Intent(this,ClassActivity.class);startActivity(i);break;
            case R.id.videoCard : i = new Intent(this,VideoActivity.class);startActivity(i);break;
            case R.id.exerciseCard : i = new Intent(this,ExerciseActivity.class);startActivity(i);break;
            case R.id.profileCard : i = new Intent(this,ProfileActivity.class);startActivity(i);break;
            default:break;
        }
    }
}
