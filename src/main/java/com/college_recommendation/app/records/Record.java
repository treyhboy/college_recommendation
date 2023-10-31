package com.college_recommendation.app.records;

import lombok.Data;

@Data
public class Record {
    private String collegeName;
    private String city;
    private String state;
    private String type;
    private String subjects;
    private int greScore;
    private int gmatScore;
    private int enrolledStudents;
    private int faculties;
    private int fees;
    private String size;
    private String campusType;
    private int graduationRate;
    private int placementRate;
    private int yearFound;
    private String sports;
}
