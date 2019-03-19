package com.poc.sample;

import java.util.ArrayList;

public class Dsapusecases
{
    private String masterusecase;

    private String MasterUseCaseCollibraId;

    private String UseCaseCollibraID;

    private ArrayList<Assettables> assettables;

    private String usecasename;

    public String getMasterusecase ()
    {
        return masterusecase;
    }

    public void setMasterusecase (String masterusecase)
    {
        this.masterusecase = masterusecase;
    }

    public String getMasterUseCaseCollibraId ()
    {
        return MasterUseCaseCollibraId;
    }

    public void setMasterUseCaseCollibraId (String MasterUseCaseCollibraId)
    {
        this.MasterUseCaseCollibraId = MasterUseCaseCollibraId;
    }

    public String getUseCaseCollibraID ()
    {
        return UseCaseCollibraID;
    }

    public void setUseCaseCollibraID (String UseCaseCollibraID)
    {
        this.UseCaseCollibraID = UseCaseCollibraID;
    }

    public ArrayList<Assettables> getAssettables ()
    {
        return assettables;
    }

    public void setAssettables (ArrayList<Assettables> assettables)
    {
        this.assettables = assettables;
    }

    public String getUsecasename ()
    {
        return usecasename;
    }

    public void setUsecasename (String usecasename)
    {
        this.usecasename = usecasename;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [masterusecase = "+masterusecase+", MasterUseCaseCollibraId = "+MasterUseCaseCollibraId+", UseCaseCollibraID = "+UseCaseCollibraID+", assettables = "+assettables+", usecasename = "+usecasename+"]";
    }
}
