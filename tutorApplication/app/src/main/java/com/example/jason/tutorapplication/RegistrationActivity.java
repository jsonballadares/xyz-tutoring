package com.example.jason.tutorapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText etPassword;
    private EditText etEmail;
    private EditText etAddress;
    private EditText etPhone;
    private EditText etChildsName;
    private EditText etChildsGrade;
    private EditText etChildSubject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        etChildsName = findViewById(R.id.etChildsName);
        etChildsGrade = findViewById(R.id.etSubject);
        etChildSubject = findViewById(R.id.etSubject);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

    }

    public void onSubmitButtonClick(){

        //todo add string xml values for this one

        //save the name
        String email = etEmail.getText().toString();
        mEditor.putString(getString(R.string.email), email);
        mEditor.commit();

        //save the password
        String password = etPassword.getText().toString();
        mEditor.putString(getString(R.string.pass), password);
        mEditor.commit();

        //save the address
        String address = etAddress.getText().toString();
        mEditor.putString(getString(R.string.address), address);
        mEditor.commit();

        //save the phone
        String phone = etPhone.getText().toString();
        mEditor.putString(getString(R.string.phone), phone);
        mEditor.commit();

        //save the childsName
        String childsName = etChildsName.getText().toString();
        mEditor.putString(getString(R.string.childsName), childsName);
        mEditor.commit();

        //save the childsGrade
        String childsGrade = etChildsGrade.getText().toString();
        mEditor.putString(getString(R.string.childsGrade), childsGrade);
        mEditor.commit();

        //save the childsSubject
        String childsSubject = etChildSubject.getText().toString();
        mEditor.putString(getString(R.string.childsSubject), childsSubject);
        mEditor.commit();


        Intent intent = new Intent(RegistrationActivity.this, ConfirmRegistration.class);
        startActivity(intent);
    }
}
