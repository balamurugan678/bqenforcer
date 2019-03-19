package com.poc.sample;

import java.util.ArrayList;

class ViewDefinition
{
    private ArrayList<ruleids> RuleIDs;

    private String ProjectName;

    private String DatasetName;

    private String CreationTimeStamp;

    private String ViewSQL;

    private String UseCaseName;

    private String TableName;

    private int VersionNumber;

    private String ParentUseCase;

    private String ViewName;

    public ArrayList<ruleids> getRuleIDs ()
    {
        return RuleIDs;
    }

    public void setRuleIDs (ArrayList<ruleids> RuleIDs)
    {
        this.RuleIDs = RuleIDs;
    }

    public String getDatasetName ()
    {
        return DatasetName;
    }

    public String getProjectName ()
    {
        return ProjectName;
    }

    public void setDatasetName (String DatasetName)
    {
        this.DatasetName = DatasetName;
    }

    public void setProjectName (String ProjectName)
    {
        this.ProjectName = ProjectName;
    }

    public String getCreationTineStamp ()
    {
        return CreationTimeStamp;
    }

    public void setCreationTimeStamp (String CreationTineStamp)
    {
        this.CreationTimeStamp = CreationTineStamp;
    }

    public String getViewSQL ()
    {
        return ViewSQL;
    }

    public void setViewSQL (String ViewSQL)
    {
        this.ViewSQL = ViewSQL;
    }

    public String getUseCaseName ()
    {
        return UseCaseName;
    }

    public void setUseCaseName (String UseCaseName)
    {
        this.UseCaseName = UseCaseName;
    }

    public String getTableName ()
    {
        return TableName;
    }

    public void setTableName (String TableName)
    {
        this.TableName = TableName;
    }

    public int getVersionNumber ()
    {
        return VersionNumber;
    }

    public void setVersionNumber (int VersionNumber)
    {
        this.VersionNumber = VersionNumber;
    }

    public String getParentUseCase ()
    {
        return ParentUseCase;
    }

    public void setParentUseCase (String ParentUseCase)
    {
        this.ParentUseCase = ParentUseCase;
    }

    public String getViewName ()
    {
        return ViewName;
    }

    public void setViewName (String ViewName)
    {
        this.ViewName = ViewName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [RuleIDs = "+RuleIDs+", DatasetName ="+DatasetName+", ProjectName = "+ProjectName+", CreationTineStamp = "+CreationTimeStamp+", ViewSQL = "+ViewSQL+", UseCaseName = "+UseCaseName+", TableName = "+TableName+", VersionNumber = "+VersionNumber+", ParentUseCase = "+ParentUseCase+", ViewName = "+ViewName+"]";
    }
}

