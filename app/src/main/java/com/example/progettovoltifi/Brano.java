package com.example.progettovoltifi;

import android.widget.Spinner;

import java.util.Date;

public class Brano
{

    private String titolo;
    private int durata;
    private String autore;
    private String datacreazione;
    private String genere;

    public Brano(String titolo, int durata, String autore, String datacreazione, String genere)
    {
        this.titolo=titolo;
        this.durata=durata;
        this.autore=autore;
        this.datacreazione=datacreazione;
        this.genere=genere;
    }

    public String getTitolo()
    {
        return titolo;
    }

    public void setTitolo(String titolo)
    {
        this.titolo = titolo;
    }

    public int getDurata()
    {
        return durata;
    }

    public void setDurata(int durata)
    {
        this.durata = durata;
    }

    public String getAutore()
    {
        return autore;
    }

    public void setAutore(String autore)
    {
        this.autore = autore;
    }

    public String getDatacreazione()
    {
        return datacreazione;
    }

    public void setDatacreazione(String datacreazione)
    {
        this.datacreazione = datacreazione;
    }

    public String getGenere()
    {
        return genere;
    }

    public void setGenere(String genere)
    {
        this.genere = genere;
    }

    @Override
    public String toString()
    {
        return "Brano{" +
                "titolo='" + titolo + '\'' +
                ", durata=" + durata +
                ", autore='" + autore + '\'' +
                ", datacreazione='" + datacreazione + '\'' +
                ", genere=" + genere +
                '}';
    }
}
