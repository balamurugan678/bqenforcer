package com.poc.sample;

import java.util.ArrayList;
public class MainObject
{
    private ArrayList<Dsapusecases> dsapusecases;

    public ArrayList<Dsapusecases> getDsapusecases ()
    {
        return dsapusecases;
    }

    public void setDsapusecases (ArrayList<Dsapusecases> dsapusecases)
    {
        this.dsapusecases = dsapusecases;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dsapusecases = "+dsapusecases+"]";
    }
}
