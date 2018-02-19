package com.example.jason.tutorapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private SharedPreferences regPreferences;
    private SharedPreferences.Editor regEditor;

    private EditText etPassword;
    private EditText etEmail;
    private EditText etAddress;
    private EditText etPhone;
    private EditText etChildsName;
    private EditText etChildsGrade;
    private EditText etChildSubject;
    private RadioGroup rg;
    private RadioButton rbSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        rg = findViewById(R.id.radioGroupPayment);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        etChildsName = findViewById(R.id.etChildsName);
        etChildsGrade = findViewById(R.id.etSubject);
        etChildSubject = findViewById(R.id.etSubject);

        regPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        regEditor = regPreferences.edit();

    }

    public void rbClick(View view){

        int radioButtonID = rg.getCheckedRadioButtonId();
        rbSelected = findViewById(radioButtonID);

        //todo actually do something with this input

    }

    public void onSubmitButtonClick(View view){

        //save the name
        String email = etEmail.getText().toString();
        regEditor.putString(getString(R.string.email), email);
        regEditor.commit();

        //save the password
        String password = etPassword.getText().toString();
        regEditor.putString(getString(R.string.pass), password);
        regEditor.commit();

        //save the address
        String address = etAddress.getText().toString();
        regEditor.putString(getString(R.string.address), address);
        regEditor.commit();

        //save the phone
        String phone = etPhone.getText().toString();
        regEditor.putString(getString(R.string.phone), phone);
        regEditor.commit();

        //save the childsName
        String childsName = etChildsName.getText().toString();
        regEditor.putString(getString(R.string.childsName), childsName);
        regEditor.commit();

        //save the childsGrade
        String childsGrade = etChildsGrade.getText().toString();
        regEditor.putString(getString(R.string.childsGrade), childsGrade);
        regEditor.commit();

        //save the childsSubject
        String childsSubject = etChildSubject.getText().toString();
        regEditor.putString(getString(R.string.childsSubject), childsSubject);
        regEditor.commit();

        //start the next activity
        Intent intent = new Intent(RegistrationActivity.this, ConfirmRegistration.class);
        startActivity(intent);
    }
}
