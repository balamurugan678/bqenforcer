package com.poc.sample;

import java.util.ArrayList;

public class Assettables
{
    private HostingDetails HostingDetails;

    private TableSchema TableSchema;

    private ArrayList<TableRestrictions> TableRestrictions;

    private String TableAlias;

    private String DataAsset;

    private String TableName;

    private int VersionNumber;

    private String TableID;

    private String DataAssetCategory;

    protected HostingDetails getHostingDetails ()
    {
        return HostingDetails;
    }

    public void setHostingDetails (HostingDetails HostingDetails)
    {
        this.HostingDetails = HostingDetails;
    }

    protected TableSchema getTableSchema ()
    {
        return TableSchema;
    }

    public void setTableSchema (TableSchema TableSchema)
    {
        this.TableSchema = TableSchema;
    }

    protected ArrayList<TableRestrictions> getTableRestrictions ()
    {
        return TableRestrictions;
    }

    public void setTableRestrictions (ArrayList<TableRestrictions> TableRestrictions)
    {
        this.TableRestrictions = TableRestrictions;
    }

    public String getTableAlias ()
    {
        return TableAlias;
    }

    public void setTableAlias (String TableAlias)
    {
        this.TableAlias = TableAlias;
    }

    public String getDataAsset ()
    {
        return DataAsset;
    }

    public void setDataAsset (String DataAsset)
    {
        this.DataAsset = DataAsset;
    }

    protected String getTableName ()
    {
        return TableName;
    }

    public void setTableName (String TableName)
    {
        this.TableName = TableName;
    }

    protected int getVersionNumber ()
    {
        return VersionNumber;
    }

    public void setVersionNumber (int VersionNumber)
    {
        this.VersionNumber = VersionNumber;
    }

    public String getTableID ()
    {
        return TableID;
    }

    public void setTableID (String TableID)
    {
        this.TableID = TableID;
    }

    public String getDataAssetCategory ()
    {
        return DataAssetCategory;
    }

    public void setDataAssetCategory (String DataAssetCategory)
    {
        this.DataAssetCategory = DataAssetCategory;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [HostingDetails = "+HostingDetails+", TableSchema = "+TableSchema+", TableRestrictions = "+TableRestrictions+", TableAlias = "+TableAlias+", DataAsset = "+DataAsset+", TableName = "+TableName+", VersionNumber = "+VersionNumber+", TableID = "+TableID+", DataAssetCategory = "+DataAssetCategory+"]";
    }
}

