package com.example.jason.tutorapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmRegistration extends AppCompatActivity {

    private SharedPreferences regPreferences;
    private SharedPreferences.Editor regEditor;
    private TextView textView;
    private AlertDialog dialog;
    private EditText editText;
    private String confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_registration);

        regPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        regEditor = regPreferences.edit();

        /*
        String email = regPreferences.getString(getString(R.string.email), "");
        String address = regPreferences.getString(getString(R.string.address), "");
        String phone = regPreferences.getString(getString(R.string.phone), "");
        String childsName = regPreferences.getString(getString(R.string.childsName), "");
        String childsGrade = regPreferences.getString(getString(R.string.childsGrade), "");
        String childsSubject = regPreferences.getString(getString(R.string.childsSubject), "");
         */

        String password = regPreferences.getString(getString(R.string.pass), "");

        //init vars for the text view edit
        textView = findViewById(R.id.textView);
        dialog = new AlertDialog.Builder(this).create();
        editText = new EditText(this);

        //set the textview to the entered password
        textView.setText(password);

        //
        dialog.setTitle(" Fix Password ");
        dialog.setView(editText);

        //listens for the textView to be touched shows dialog and makes the edit Text show whatever the textview has
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText.setText(textView.getText());
                dialog.show();
            }
        });

        //the textview is then edited through a edit text that is presented in the dialog and saves it to the shared preference db
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE PASSWORD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView.setText(editText.getText());
                confirmPassword = (String) textView.getText();
                regEditor.putString(getString(R.string.pass), confirmPassword);
                regEditor.commit();
            }
        });







    }
}
