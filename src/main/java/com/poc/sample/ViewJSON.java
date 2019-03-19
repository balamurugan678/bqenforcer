package com.poc.sample;

import java.util.ArrayList;

class ViewJSON
{

   private ArrayList<ViewDefinition> ViewDefinition;

    public ArrayList<ViewDefinition> getViewDefinitions ()
    {
        return ViewDefinition;
    }

    public void setViewDefinitions (ArrayList<ViewDefinition>ViewDefinitions)
    {
        this.ViewDefinition = ViewDefinitions;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [ViewDefinitions = "+ViewDefinition+"]";
    }
}
