package main;

import bean.Record;
import dao.RecordDao;
import service.AskService;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String userDecision = AskService.whatUserWants();

        switch (userDecision){
            case "ct":
                Record r = new Record();
                RecordDao.createRecord(r);
                break;
            case "a":
                Record a = new Record(111, "ukr.net", "alex2", "alex2","", "14.12.2020");
                RecordDao.add(a);
                break;
            case "v":
                Record v = new Record();
                RecordDao.view(v);
                break;
            case "e":
                System.exit(0);
        }
    }

}