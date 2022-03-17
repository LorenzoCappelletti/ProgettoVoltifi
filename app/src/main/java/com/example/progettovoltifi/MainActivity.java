package com.example.progettovoltifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * prima classe main dove vengono inizializzati tutti gli oggetti per la realizzazione della nostra activity
 */
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
    FileManager fm;
    String[] generi = {"Pop", "Rock", "Dance", "Trap"};


    /**
     * @param savedInstanceState
     * Nella classe onCreate verranno richiamati gli oggetti inizializzati precedentemente per dar loro una reference legata all'id
       presente nel file xml. Ad ogni singolo oggetto verrà così associato un id univoco. All' interno del suddetto metodo verrà istanziato anche il nostro
       arrayAdapter legato ai generi da noi scelti.  Quest'ultimo verrà applicato all oggetto spinner presente nella nostra prima activity.
     */
    String tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i =0;
        i++;
        Log.d(tag, "Lanciato il metodo onCreate " + i);

        btnInserisci = (Button) findViewById(R.id.btnInserisci);
        btnAprire = (Button) findViewById(R.id.btnAprire);

        txtTitolo = (EditText) findViewById(R.id.txtTitolo2);
        durata = (EditText) findViewById(R.id.durata);
        data_uscita = (EditText) findViewById(R.id.data);
        autore = (EditText) findViewById(R.id.autore);
        Spgenere = (Spinner) findViewById(R.id.genere);

        gb = new Gestorebrani();
        fm = new FileManager(getApplicationContext());


        // metodo eseguito in classe
        ArrayAdapter<String> array = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, generi);
        Spgenere.setAdapter(array);

        // metodo eseguito a casa
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_genere, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        //genere.setAdapter(adapter);

        btnInserisci.setOnClickListener(new View.OnClickListener()
        {

            /**
             * @param v
             * Il metodo onClick è legato al bottone btnInserisci. Esso si è andato a formare grazie alla chiamata dell'ascoltatore indirizzata verso
               lo stesso bottone. Questo metodo viene richiamato ogni volta che si cliccherà il bottone inserisci utilizzato per aggiungere l'oggetto di tipo
               brano all' interno dell'arrayList.
             */
            @Override
            public void onClick (View v)
            {

                    gb.addBrano(txtTitolo.getText().toString(), Integer.parseInt(durata.getText().toString())
                    , autore.getText().toString(), data_uscita.getText().toString(), Spgenere.getSelectedItem().toString());

                    fm.scriviFile(txtTitolo.getText().toString(), "prova.txt");

            }
        });

        btnAprire.setOnClickListener(new View.OnClickListener()
        {

            /**
             * @param v
               Analoga cosa viene fatta per il bottone btnAprire. Il metodo onClick viene così creato tramite l'ascoltatore che attiverà tale istruzione ogni volta
               che si cliccherà il bottone btnAprire. Il seguente metodo permette di stampare tutti i nostri brani sottoforma di stringa in una seconda activity tramite
               il nostro intent.
             */
            @Override
            public void onClick (View v)
            {
                StringBuilder stringa_finale = new StringBuilder();
                stringa_finale = gb.ListaBrani();
                //String stringa_finale = gb.ListaBrani();
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("stringa_finale",stringa_finale.toString());
                startActivity(i);

            }
        });

    }

    @Override
    protected void onStart()
    {
        Log.d(tag,"Siamo nel metodo onStart");
        super.onStart();
    }

}