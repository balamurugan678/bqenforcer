package com.poc.sample;

import java.util.ArrayList;

public class TableFields
{
    private String id;

    private String DataType;

    private String alias;

    private ArrayList<Restrictions> Restrictions;

    private String DataAsset;

    private String FieldName;

    private String RestrictionType;

    private String DataAssetCategory;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDataType ()
    {
        return DataType;
    }

    public void setDataType (String DataType)
    {
        this.DataType = DataType;
    }

    public String getAlias ()
    {
        return alias;
    }

    public void setAlias (String alias)
    {
        this.alias = alias;
    }

    public ArrayList<Restrictions> getRestrictions ()
    {
        return Restrictions;
    }

    public void setRestrictions (ArrayList<Restrictions> Restrictions)
    {
        this.Restrictions = Restrictions;
    }

    public String getDataAsset ()
    {
        return DataAsset;
    }

    public void setDataAsset (String DataAsset)
    {
        this.DataAsset = DataAsset;
    }

    public String getFieldName ()
    {
        return FieldName;
    }

    public void setFieldName (String FieldName)
    {
        this.FieldName = FieldName;
    }

    public String getRestrictionType ()
    {
        return RestrictionType;
    }

    public void setRestrictionType (String RestrictionType)
    {
        this.RestrictionType = RestrictionType;
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
        return "ClassPojo [id = "+id+", DataType = "+DataType+", alias = "+alias+", Restrictions = "+Restrictions+", DataAsset = "+DataAsset+", FieldName = "+FieldName+", RestrictionType = "+RestrictionType+", DataAssetCategory = "+DataAssetCategory+"]";
    }
}
