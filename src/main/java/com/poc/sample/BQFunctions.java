package com.poc.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.bigquery.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class BQFunctions {

    static void BQInsertJSON(String json_string, String DstName, String TableName) {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
        TableId tableId = TableId.of(DstName, TableName);
        try {
            HashMap mapResult = new ObjectMapper().readValue(json_string, HashMap.class);
            InsertAllResponse response;
            response = bigquery.insertAll(InsertAllRequest.newBuilder(tableId)
                    .addRow(UUID.randomUUID().toString(), mapResult)
                    .build());
            if (response.hasErrors()) {
                // If any of the insertions failed, this lets you inspect the errors
                for (Map.Entry <Long, List <BigQueryError>> entry : response.getInsertErrors().entrySet()) {
                    System.out.println("HI::::::"+entry);
                }
            }
        } catch (IOException e) {
            // Failed to Map JSON String
            System.out.println(e);
        }
    }

    static int BQReadData(String querystring) throws InterruptedException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        // Note: Standard SQL is required to use query parameters.
        QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(querystring).build();

        Integer res = 0;
// Print the results.
        for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
            for (FieldValue val : row) {
                res = Integer.parseInt(val.getValue().toString());
            }
        }
        return res;
    }
}
