package com.example.progettovoltifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{
    TextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String mesric = i.getStringExtra("stringa_finale");
        v = (TextView)findViewById(R.id.lista);
        //visione.append(mesric);
        v.setText(mesric);
    }
}