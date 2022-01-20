package com.example.progettovoltifi;

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

    public void addBrano(String titolo, int durata, String autore, String datacreazione, String genere)
    {
        Brano b = new Brano(titolo,durata,autore,datacreazione,genere);
        ListaBrani.add(b);
        System.out.println(ListaBrani);
    }

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
