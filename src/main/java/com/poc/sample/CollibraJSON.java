package com.poc.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.api.services.bigquery.Bigquery;
import com.google.gson.Gson;


import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.TableId;

import java.util.ArrayList;

import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;

import java.util.Map.Entry;
import com.google.gson.GsonBuilder;

import java.util.List;

public class CollibraJSON {

    public static void main(String[] args) throws Exception {

       String path = "/Users/balgurus1/balamurugan/assets/collibra.json";

        // store json as a file in CS as it is
        // create one file each for Use Cases and store in CS again.

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        MainObject mojo = gson.fromJson(bufferedReader, MainObject.class);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(mojo);
        BQFunctions.BQInsertJSON (json, "CollibraIAR", "TestAsset_1");


        processJSON(mojo.getDsapusecases());

    }

    private static void processJSON(ArrayList <Dsapusecases> ucase) throws Exception {

        //write DsapUseCases data in assset data table
        for (Dsapusecases DSAPUseCase : ucase) {

            //convert DSAPUseCase to JSON file and copy in CS UseCaseParent/UseCaseName
            for (Assettables tbl : DSAPUseCase.getAssettables()) {

                // store Table JSON files in CS UseCaseParent/UseCaseName/TableName and cross check version number
                TableSchema tblscm = tbl.getTableSchema();

                PopulateTableRestrictions ptblrest = new PopulateTableRestrictions(tbl.getTableRestrictions());

                String TableWhereClause = "";
                if (tbl.getHostingDetails().getCloudProviderName() == "GCP"){
                    TableWhereClause = "From `" + tbl.getHostingDetails().getDataBaseProjectName() + "." + tbl.getHostingDetails().getDataBaseName() + "." + tbl.getTableName() + "`" + ptblrest.GetTableRestrictionList(); // get table where clause
                }
                else if (tbl.getHostingDetails().getCloudProviderName() == "BigData"){
                    TableWhereClause = "From " +tbl.getTableName() + ptblrest.GetTableRestrictionList(); // get table where clause
                }

                TableWhereClause = "From `" + tbl.getHostingDetails().getDataBaseProjectName() + "." + tbl.getHostingDetails().getDataBaseName() + "." + tbl.getTableName() + "`" + ptblrest.GetTableRestrictionList(); // get table where clause

                CreateTableSelectList ptblflds = new CreateTableSelectList(tblscm.getTableFields());

                String selectlist = "Select " + ptblflds.GetTableSelectList();
                String ViewDefinition = selectlist + " " + TableWhereClause;

                PopulateViewJSON pj = new PopulateViewJSON();
                System.out.println("Hiiii"+ViewDefinition);
                pj.GetViewJSON(ViewDefinition, DSAPUseCase.getMasterusecase(), DSAPUseCase.getUsecasename(), tbl);
            }
        }
    }

    interface UpdateBQ {
        void Foo(String s);
    }
}

