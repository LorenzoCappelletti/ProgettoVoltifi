package com.example.progettovoltifi;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;

public class Gestorebrani
{
    ArrayList<Brano> ListaBrani;

    public Gestorebrani()
    {
        ListaBrani = new ArrayList<Brano>();
    }

    /**
     * @param titolo
     * @param durata
     * @param autore
     * @param datacreazione
     * @param genere
     * Il metodo addBrano permette di aggiungere un singolo brano all'interno del nostro arrayList istanziato nelle righe precedenti.
     */
    public void addBrano(String titolo, int durata, String autore, String datacreazione, String genere)
    {
        Brano b = new Brano(titolo,durata,autore,datacreazione,genere);
        ListaBrani.add(b);
        System.out.println(ListaBrani);
        //Log.d("Gestore Brani","inserimento oggetto brano nell'array");

    }

    /**
     * @return
     * Il metodo Listabrani permette di concatenare tutti i nostri brani presenti nell'array in una grande stringa più facile da modificare.
       Tutto questo è stato reso possibile grazie alla creazione di un oggetto di tipo stringbuilder che avrà come contenuto tutta la lista dei brani presenti.
     */
    public StringBuilder ListaBrani()
    {
        StringBuilder stBrani = new StringBuilder();
        for(Brano bV : ListaBrani)
        {
            stBrani.append(bV.toString()); // metodo messo in un ciclo per concatenare.
            //stBrani.append(bV.getTitolo().toString());
            //stBrani.append(bV.getAutore().toString());

        }

        return stBrani;
    }


}
