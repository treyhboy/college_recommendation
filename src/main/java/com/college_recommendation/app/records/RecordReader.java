package com.college_recommendation.app.records;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordReader {
    public List<Record> getRecords() {
        List<Record> records = new ArrayList<>();
        try {
            // Create a FileReader for your CSV file
            FileReader fileReader = new FileReader("data.csv");

            // Create a CSVReader using CSVReaderBuilder
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1) // Skip the header if it exists
                    .build();

            // Read and parse the CSV data
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                Record record = new Record();
                record.setCollegeName(nextRecord[0]);
                record.setCity(nextRecord[1]);
                record.setState(nextRecord[2]);
                record.setType(nextRecord[3]);
                record.setSubjects(nextRecord[4]);
                record.setGreScore(Integer.parseInt(nextRecord[5]));
                record.setGmatScore(Integer.parseInt(nextRecord[6]));
                record.setEnrolledStudents(Integer.parseInt(nextRecord[7]));
                record.setFaculties(Integer.parseInt(nextRecord[8]));
                record.setFees(Integer.parseInt(nextRecord[9]));
                record.setSize(nextRecord[10]);
                record.setCampusType(nextRecord[11]);
                record.setGraduationRate(Integer.parseInt(nextRecord[12]));
                record.setPlacementRate(Integer.parseInt(nextRecord[13]));
                record.setYearFound(Integer.parseInt(nextRecord[14]));
                record.setSports(nextRecord[15]);
                records.add(record);
            }

            // Close the CSVReader
            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return records;
    }
}