package com.poc.sample;

import java.util.ArrayList;

public class TableSchema
{
    private ArrayList<TableFields> TableFields;

    public ArrayList<TableFields> getTableFields ()
    {
        return TableFields;
    }

    public void setTableFields (ArrayList<TableFields> TableFields)
    {
        this.TableFields = TableFields;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TableFields = "+TableFields+"]";
    }
}
