package com.college_recommendation.app.controller.models;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class Body {
    @JsonProperty("gre_score")
    private int greScore;
    @JsonProperty("subject")
    private String subject;
}
