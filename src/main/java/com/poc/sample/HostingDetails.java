package com.poc.sample;

public class HostingDetails
{
    private String TableLocation;

    private String DataBasePort;

    private String CloudProviderName;

    private String DataBaseProjectName;

    private String DataBaseName;

    public String getTableLocation ()
    {
        return TableLocation;
    }

    public void setTableLocation (String TableLocation)
    {
        this.TableLocation = TableLocation;
    }

    public String getDataBasePort ()
    {
        return DataBasePort;
    }

    public void setDataBasePort (String DataBasePort)
    {
        this.DataBasePort = DataBasePort;
    }

    public String getCloudProviderName ()
    {
        return CloudProviderName;
    }

    public void setCloudProviderName (String CloudProviderName)
    {
        this.CloudProviderName = CloudProviderName;
    }

    public String getDataBaseProjectName ()
    {
        return DataBaseProjectName;
    }

    public void setDataBaseProjectName (String DataBaseProjectName)
    {
        this.DataBaseProjectName = DataBaseProjectName;
    }

    public String getDataBaseName ()
    {
        return DataBaseName;
    }

    public void setDataBaseName (String DataBaseName)
    {
        this.DataBaseName = DataBaseName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TableLocation = "+TableLocation+", DataBasePort = "+DataBasePort+", CloudProviderName = "+CloudProviderName+", DataBaseProjectName = "+DataBaseProjectName+", DataBaseName = "+DataBaseName+"]";
    }
}
