package com.poc.sample;

public class Fields
{
    private String operation;

    private String DataType;

    private String dsaprule_id;

    private String name;

    private String value;

    public String getOperation ()
    {
        return operation;
    }

    public void setOperation (String operation)
    {
        this.operation = operation;
    }

    public String getDataType ()
    {
        return DataType;
    }

    public void setDataType (String DataType)
    {
        this.DataType = DataType;
    }

    public String getDsaprule_id ()
    {
        return dsaprule_id;
    }

    public void setDsaprule_id (String dsaprule_id)
    {
        this.dsaprule_id = dsaprule_id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [operation = "+operation+", DataType = "+DataType+", dsaprule_id = "+dsaprule_id+", name = "+name+", value = "+value+"]";
    }
}
