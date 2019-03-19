package com.poc.sample;

class ruleids
{
    private String AssetName;

    private String RuleID;

    public String getAssetName ()
    {
        return AssetName;
    }

    public void setAssetName (String AssetName)
    {
        this.AssetName = AssetName;
    }

    public String getRuleID ()
    {
        return RuleID;
    }

    public void setRuleID (String RuleID)
    {
        this.RuleID = RuleID;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [AssetName = "+AssetName+", RuleID = "+RuleID+"]";
    }
}

