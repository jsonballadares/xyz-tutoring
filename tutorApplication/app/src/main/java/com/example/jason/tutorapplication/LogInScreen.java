package com.example.jason.tutorapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LogInScreen extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //mPreferences will hold all the data
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

        //default settings for editing and storing of data
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

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
                    //set a checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox), "False");

                    mEditor.commit();

                    //save the name
                    mEditor.putString(getString(R.string.name), "");
                    mEditor.commit();

                    //save the password
                    mEditor.putString(getString(R.string.password), "");
                    mEditor.commit();
                }
            }
        });


    }





    /**
     * Check the shared preferences and set them accordingly
     */
    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String name = mPreferences.getString(getString(R.string.name), "");
        String password = mPreferences.getString(getString(R.string.password), "");



        mName.setText(name);
        mPassword.setText(password);

        if(checkbox.equals("True")){
            mCheckBox.setChecked(true);
        }else{
            mCheckBox.setChecked(false);
        }

    }


}
