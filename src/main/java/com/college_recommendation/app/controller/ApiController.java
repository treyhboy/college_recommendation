package com.college_recommendation.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.college_recommendation.app.controller.models.Body;
import com.college_recommendation.app.records.Record;
import com.college_recommendation.app.records.RecordReader;


@RestController
@RequestMapping("/get_college")
public class ApiController {
    @PostMapping("/by_subject_and_score")
    public List<Record> getBySubjectAndScore(@RequestBody Body body) {
        RecordReader recordReader = new RecordReader();
        List<Record> records = recordReader.getRecords();
        List<Record> filteredRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getSubjects().contains(body.getSubject())) {
                if (record.getGreScore() <= body.getGreScore()) {
                    filteredRecords.add(record);
                }
            }
        }
        return filteredRecords;
    }
    @PostMapping("/by_subject")
    public List<Record> getBySubject(@RequestBody Body body) {
        RecordReader recordReader = new RecordReader();
        List<Record> records = recordReader.getRecords();
        List<Record> filteredRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getSubjects().contains(body.getSubject())) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords;
    }
    @PostMapping("/by_faculties")
    public Record getByFaculties(@RequestBody Body body) {
        RecordReader recordReader = new RecordReader();
        List<Record> records = recordReader.getRecords();
        List<Record> filteredRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getSubjects().contains(body.getSubject())) {
                filteredRecords.add(record);
            }
        }
        Record finalResult = filteredRecords.get(0);
        for (Record record : filteredRecords) {
            if (record.getFaculties()>finalResult.getFaculties()) {
                finalResult = record;
            }
        }
        return finalResult;
    }
}