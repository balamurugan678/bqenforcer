package com.poc.sample;

import java.util.ArrayList;

public class TableRestrictions
{
    private ArrayList<Fields> fields;

    public ArrayList<Fields> getFields ()
    {
        return fields;
    }

    public void setFields (ArrayList<Fields> fields)
    {
        this.fields = fields;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [fields = "+fields+"]";
    }
}