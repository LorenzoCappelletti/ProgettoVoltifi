package com.example.progettovoltifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{
    TextView v;

    /**
     * @param savedInstanceState
     * In questo metodo viene richiamato l'intent che permetterà di prendere il nostro messaggio, presente nella prima activity, tramite la funzione
       getStringExtra(). Una volta ripreso il testo, esso verrà stampato nella seconda activity all'interno di una textView.
     */
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