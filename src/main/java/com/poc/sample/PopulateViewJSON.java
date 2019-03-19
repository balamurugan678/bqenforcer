package com.poc.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

class PopulateViewJSON {

    void GetViewJSON(String ViewDefinition, String MasterUseCase, String UseCaseName, Assettables tbl) throws Exception {
        ViewJSON vinst = new ViewJSON();

        // fill view definition object
        ViewDefinition vdef = new ViewDefinition();
        vdef.setViewSQL(ViewDefinition);

        vdef.setParentUseCase(MasterUseCase);
        vdef.setUseCaseName(UseCaseName);
        vdef.setProjectName(tbl.getHostingDetails().getDataBaseProjectName());
        vdef.setDatasetName(tbl.getHostingDetails().getDataBaseName());
        vdef.setViewName(tbl.getTableName());
        vdef.setTableName(tbl.getTableName());
        vdef.setVersionNumber(tbl.getVersionNumber());

        ArrayList <ruleids> rids = new ArrayList <ruleids>();
        ruleids rid = new ruleids();
        rid.setAssetName("2");
        rid.setRuleID("2");
        rids.add(rid);
        vdef.setRuleIDs(rids);

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        vdef.setCreationTimeStamp(ts.toString());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(vdef);

        //send string to pub/sub to process and create views
        String msg = UseCaseName.replace(" ","_") + "|" + tbl.getTableName() + "|" + ViewDefinition;

        // check if definition is latest otherwise ignore
        // get version number form BQ table to cross check.

        String queryString = "Select count(*) from `CollibraIAR.ViewDefinition` where useCaseName = '" + UseCaseName + "' and ViewName = '" + tbl.getTableName() + "' AND Versionnumber=" + tbl.getVersionNumber();
        if (BQFunctions.BQReadData(queryString) ==  0) {
            publishview(tbl.getHostingDetails().getDataBaseProjectName(), "ViewCreationDataFlow", msg);
            BQFunctions.BQInsertJSON(json, "CollibraIAR", "ViewDefinition");
        }
    }

    private void publishview(String prjId, String topicid, String message) throws Exception {
        CreateTopicAndPublishMessages.publishMessages(prjId,topicid,message);
    }
}
