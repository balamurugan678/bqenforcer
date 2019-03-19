package com.poc.sample;

import java.util.ArrayList;

class PopulateTableRestrictions {

    private ArrayList<TableRestrictions> tblRests;

    public PopulateTableRestrictions(ArrayList<TableRestrictions> tblRestrictions){
        tblRests =  tblRestrictions;
    }

    public String GetTableRestrictionList() {
        StringBuilder  res = new StringBuilder();
        ArrayList<String> tablerestrictions_tmp = new ArrayList<String>();
        for (TableRestrictions tblres : tblRests) { // table restrictions
            for (Fields fld : tblres.getFields()) {
                if (fld.getDataType().toUpperCase().equals("STRING")) {  //  create where clause
                    tablerestrictions_tmp.add(fld.getName() + " " + fld.getOperation() + " '" + fld.getValue() + "' ");
                } else {
                    tablerestrictions_tmp.add(fld.getName() + " " + fld.getOperation() + fld.getValue());
                }
            }
        }

        if (!tablerestrictions_tmp.isEmpty()) {
            res.append(" WHERE ");
            for (String s : tablerestrictions_tmp) {
                res.append(s).append(" AND ");
            }
        }
        else
        {
            return "";
        }
        int i = res.toString().lastIndexOf(" AND");
        return res.toString().substring(0, i);
    }

    public String GetTableRestrictionList(ArrayList<TableRestrictions> tblRestrictions) {
        StringBuilder  res = new StringBuilder();
        ArrayList<String> tablerestrictions_tmp = new ArrayList<String>();
        for (TableRestrictions tblres : tblRestrictions) { // table restrictions
            for (Fields fld : tblres.getFields()) {
                if (fld.getDataType().toUpperCase().equals("STRING")) {  //  create where clause
                    tablerestrictions_tmp.add(fld.getName() + " " + fld.getOperation() + " '" + fld.getValue() + "' ");
                } else {
                    tablerestrictions_tmp.add(fld.getName() + " " + fld.getOperation() + fld.getValue());
                }
            }
        }

        if (!tablerestrictions_tmp.isEmpty()) {
            res.append(" WHERE ");
            for (String s : tablerestrictions_tmp) {
                res.append(s).append(" AND ");
            }
        }
        else
        {
            return "";
        }
        int i = res.toString().lastIndexOf(" AND");
        return res.toString().substring(0, i);
    }

}
