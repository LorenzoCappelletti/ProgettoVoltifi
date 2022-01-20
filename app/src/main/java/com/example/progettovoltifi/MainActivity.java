package com.example.progettovoltifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    Button btnInserisci; // primo bottone
    Button btnAprire; // secondo bottone

    EditText txtTitolo; // EditText titolo
    EditText durata; // EditText durata
    EditText data_uscita; // EditText data_uscita
    EditText autore; // EditText autore
    Spinner Spgenere;  // Spinner genere

    Gestorebrani gb;
    String[] generi = {"Pop", "Rock", "Dance", "Trap"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInserisci = (Button) findViewById(R.id.btnInserisci);
        btnAprire = (Button) findViewById(R.id.btnAprire);

        txtTitolo = (EditText) findViewById(R.id.txtTitolo2);
        durata = (EditText) findViewById(R.id.durata);
        data_uscita = (EditText) findViewById(R.id.data_uscita);
        autore = (EditText) findViewById(R.id.autore);
        Spgenere = (Spinner) findViewById(R.id.genere);

        gb = new Gestorebrani();

        // metodo eseguito in classe
        ArrayAdapter<String> array = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, generi);
        Spgenere.setAdapter(array);

        // metodo eseguito a casa
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_genere, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        //genere.setAdapter(adapter);

        btnInserisci.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick (View v)
            {

                    gb.addBrano(txtTitolo.getText().toString(), Integer.parseInt(durata.getText().toString())
                    , autore.getText().toString(), data_uscita.getText().toString(), Spgenere.getSelectedItem().toString());

            }
        });

        btnAprire.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick (View v)
            {
                StringBuilder stringa_finale = new StringBuilder();
                stringa_finale = gb.ListaBrani();
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("stringa_finale",stringa_finale.toString());
                startActivity(i);
            }
        });

    }



}