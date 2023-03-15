package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private String numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radio = findViewById(R.id.radioGroup);
        int radioSel = radio.getCheckedRadioButtonId();
        RadioButton radioBot = findViewById(radioSel);
        numero = radioBot.getText().toString();
        numero= "tel:"+numero;

    }

    public void launchSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        }

    @SuppressLint("QueryPermissionsNeeded")
    public void makeCall(View view) {
        Log.d("MainActivity", numero);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        if (intent.resolveActivity(getPackageManager()) != null) {
            intent.setData(Uri.parse(numero));
            startActivity(intent);
        }

    }
}