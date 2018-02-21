package com.example.jason.tutorapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LogInScreen extends AppCompatActivity {

    //mPreferences will hold user data
    //mEditor will be used to edit/access that data
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    //these fields will represent gui elements
    private EditText mName, mPassword;
    private Button btnLogin;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        //connects the fields with actual gui IDs
        mName = findViewById(R.id.etUserName);
        mPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btLogIn);
        mCheckBox = findViewById(R.id.cbRemember);

        //make a shared preferences with the default file (strings.xml)
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        //checks for for previous data
        checkSharedPreferences();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save the checkbox preference
                if(mCheckBox.isChecked()){

                    String empty = "";

                    if(!mName.getText().toString().equals(empty) && !mPassword.getText().toString().equals(empty)){
                        //set a checkbox when the application starts
                        mEditor.putString(getString(R.string.checkbox), "True");
                        mEditor.commit();

                        //save the name
                        String name = mName.getText().toString();
                        mEditor.putString(getString(R.string.name), name);
                        mEditor.commit();

                        //save the password
                        String password = mPassword.getText().toString();
                        mEditor.putString(getString(R.string.password), password);
                        mEditor.commit();

                        //sends intent to data to getIntent() of the activity
                        Intent intent = new Intent(LogInScreen.this, MainMenu.class);
                        Bundle data = new Bundle();
                        data.putString("email",name);
                        intent.putExtras(data);
                        startActivity(intent);
                    }else {
                        buttonLogIn();
                    }
                }else{
                    buttonLogIn();
                }
            }
        });


    }

    /**
     * the user logs in without using the checkbox
     */
    public void buttonLogIn(){
        String empty = "";

        if(!mName.getText().toString().equals(empty) && !mPassword.getText().toString().equals(empty)){
            //set a checkbox when the application starts
            mEditor.putString(getString(R.string.checkbox), "False");

            //save the name
            String name = mName.getText().toString();
            mEditor.putString(getString(R.string.name), name);
            mEditor.commit();

            //save the password
            String password = mPassword.getText().toString();
            mEditor.putString(getString(R.string.password), password);
            mEditor.commit();

            //start the next activity along with sending it the name through an intent
            Intent intent = new Intent(LogInScreen.this, MainMenu.class);
            Bundle data = new Bundle();
            data.putString("email",name);
            intent.putExtras(data);
            startActivity(intent);

        }else {

            Toast toast = Toast.makeText(this,"YOU SHALL NOT PASS", Toast.LENGTH_SHORT);
            youShallNotPass();
            toast.show();

        }
    }

    /**
     * Check the shared preferences and set them accordingly
     */
    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String name = mPreferences.getString(getString(R.string.name), "");
        String password = mPreferences.getString(getString(R.string.password), "");

        if(checkbox.equals("True")){
            mCheckBox.setChecked(true);
            mName.setText(name);
            mPassword.setText(password);
        }else{
            mCheckBox.setChecked(false);
            mName.setText("");
            mPassword.setText("");
        }

    }

    /**
     * Sends user to Registration Activity
     */
    public void OnClickRegister(View view){

        Intent intent = new Intent(LogInScreen.this, RegistrationActivity.class);
        startActivity(intent);

    }

    /**
     * You shall not pass audio
     */

    public void youShallNotPass(){

        final MediaPlayer gandalf = MediaPlayer.create(this,R.raw.gandalf);
        gandalf.start();

    }

}
