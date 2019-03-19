package com.poc.sample;

import java.util.ArrayList;
import java.util.Collection;

class CreateTableSelectList {

    private ArrayList<TableFields>  tblfields;

    CreateTableSelectList(ArrayList<TableFields> tblFields){
        tblfields =  tblFields;
    }

    String GetTableSelectList(){
        StringBuilder sb = new StringBuilder();
        for (TableFields flds : tblfields) { // table fields
            //  System.out.println(flds.getRestrictionType());
            if (flds.getRestrictionType().equals("null"))   { // if no restriction use field name
                // System.out.println(flds.getRestrictionType());
                sb.append(flds.getFieldName()).append(" AS ").append(flds.getFieldName());

                sb.append(",");
            } else {
                Collection<Restrictions> fldres = flds.getRestrictions();

                // if compare values than replace func else actual field.

                if (ColumnRestrictionList( flds.getRestrictions()).equals("")) {
                    sb.append(ReplaceFunction(flds.getRestrictionType(), flds.getFieldName())).append(" as ").append(flds.getFieldName());
                }
                else
                {
                    sb.append(ColumnRestrictionList(flds.getRestrictions())).append(",").append(ReplaceFunction(flds.getRestrictionType(), flds.getFieldName())).append(",").append(flds.getFieldName()).append(" ) as ").append(flds.getFieldName());
                    // sb.append(ReplaceFunction(flds.getRestrictionType(), flds.getFieldName()) + ColumnRestrictionList( flds.getRestrictions()) + " AS " + flds.getFieldName() );
                }
                //  sb.append(flds.getRestrictionType() + "(" + flds.getFieldName() + ") " + ColumnRestrictionList( flds.getRestrictions())  + " AS " + flds.getFieldName());
                sb.append(",");
            }
        }
        int i = sb.toString().lastIndexOf(",");
        return sb.toString().substring(0, i);

    }

    public String GetTableSelectList(ArrayList<TableFields> tblFields){

        StringBuilder sb = new StringBuilder();
        for (TableFields flds : tblFields) { // table fields
            //  System.out.println(flds.getRestrictionType());
            if (flds.getRestrictionType().equals("null"))   { // if no restriction use field name
                // System.out.println(flds.getRestrictionType());
                sb.append(flds.getFieldName()).append(" AS ").append(flds.getFieldName());

                sb.append(",");
            } else {
                // if compare values than replace func else actual field.

                if (ColumnRestrictionList( flds.getRestrictions()).equals("")) {
                    sb.append(ReplaceFunction(flds.getRestrictionType(), flds.getFieldName())).append(" as ").append(flds.getFieldName());
                }
                else
                {
                    sb.append(ColumnRestrictionList(flds.getRestrictions())).append(",").append(ReplaceFunction(flds.getRestrictionType(), flds.getFieldName())).append(",")
                            .append(flds.getFieldName()).append(" ) as ").append(flds.getFieldName())
                            .append("/* rule ids */");
                    // sb.append(ReplaceFunction(flds.getRestrictionType(), flds.getFieldName()) + ColumnRestrictionList( flds.getRestrictions()) + " AS " + flds.getFieldName() );
                }
                //  sb.append(flds.getRestrictionType() + "(" + flds.getFieldName() + ") " + ColumnRestrictionList( flds.getRestrictions())  + " AS " + flds.getFieldName());
                sb.append(",");
            }
        }
        int i = sb.toString().lastIndexOf(",");
        return sb.toString().substring(0, i);
    }

    private String ReplaceFunction(String fnName, String fldName){
        String fFld = "";

        if (fnName.equals("Generalization"))
        {
            return "CONCAT(CONCAT(CAST(ROUND(" + fldName + "/5000)*5000 AS STRING),'-', CAST(ROUND(" + fldName + "/5000)*5000+5000 AS STRING)))";
        }
        else if (fnName.equals("Anonymisation"))
        {
            return "TO_HEX(SHA256(" + fldName + "))";
        }
        else if (fnName.equals("Masking"))
        {
            return ""; //"REGEXP_REPLACE(" + fldName + ",r"\d{2}$", REPEAT('*',2))";
        }
        return fFld;
    }

    private String ColumnRestrictionList(Collection<Restrictions> colRestrictions) {
        StringBuilder  res = new StringBuilder();
        ArrayList<String> tablerestrictions_tmp = new ArrayList<String>();
        for (Restrictions colres : colRestrictions) { // table restrictions
            for (Fields fld : colres.getFields()) { // table restrictions
                if (fld.getDataType().toUpperCase().equals("STRING")) {  //  create where clause
                    tablerestrictions_tmp.add(fld.getName() + " " + fld.getOperation() + " '" + fld.getValue() + "' ");
                } else if (!fld.getDataType().toUpperCase().equals("NULL")) {
                    tablerestrictions_tmp.add(fld.getName() + " " + fld.getOperation() + fld.getValue());
                } else {
                   // tablerestrictions_tmp.add("");
                }
            }
        }

        if (!tablerestrictions_tmp.isEmpty()) {
            for (String s : tablerestrictions_tmp) {
                res.append(s).append(" AND ");
            }
        }
        else
        {
            return "";
        }
        int i = res.toString().lastIndexOf(" AND");
        return " IF (" + res.toString().substring(0, i) ;
    }
}