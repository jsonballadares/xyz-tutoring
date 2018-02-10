package com.example.jason.tutorapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    //mEditor will be used to edit that data
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    //these fields will represent gui elements
    private EditText mName, mPassword;
    private Button btnLogin,btnRegister;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        //connects the fields with actual gui IDs
        mName = findViewById(R.id.editTextUserName);
        mPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        mCheckBox = findViewById(R.id.checkbox);

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

                    Intent intent = new Intent(LogInScreen.this, MainMenu.class);
                    startActivity(intent);


                }else{
                    buttonLogIn();

                    //set a checkbox when the application starts
                    //mEditor.putString(getString(R.string.checkbox), "False");

                   // mEditor.commit();

                    //save the name
                   // mEditor.putString(getString(R.string.name), "");
                   // mEditor.commit();

                    //save the password
                  //  mEditor.putString(getString(R.string.password), "");
                  //  mEditor.commit();
                }
            }
        });


    }

    /**
     * the user logs in without using the checkbox
     */
    public void buttonLogIn(){

        mEditor.putString(getString(R.string.checkbox), "False");
        //save the name
        String name = mName.getText().toString();
        mEditor.putString(getString(R.string.name), name);
        mEditor.commit();

        //save the password
        String password = mPassword.getText().toString();
        mEditor.putString(getString(R.string.password), password);
        mEditor.commit();


        Intent intent = new Intent(LogInScreen.this, MainMenu.class);
        startActivity(intent);


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

}
