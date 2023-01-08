package com.example.laboratoryworkjava4.model;


import com.example.laboratoryworkjava4.service.GreatestCommonDivisiorService;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class GreatestCommonDivisiorResult {
    private Integer ID;

    private Integer Result;
    private Integer FirstNumber;
    private Integer SecondNumber;
    private String Type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<List<Integer>> Step;



    public GreatestCommonDivisiorResult ID (Integer ID) {
        this.ID = ID;
        return this;
    }
    public GreatestCommonDivisiorResult FirstNumber (Integer FirstNumber) {
        this.FirstNumber = FirstNumber;
        return this;
    }
    public GreatestCommonDivisiorResult SecondNumber (Integer SecondNumber) {
        this.SecondNumber = SecondNumber;
        return this;
    }
    public GreatestCommonDivisiorResult Type (String Type) {
        this.Type = Type;
        return this;
    }
    public GreatestCommonDivisiorResult Step (List<List<Integer>> Step) {
        this.Step = Step;
        return this;
    }
    public GreatestCommonDivisiorResult Result (Integer Result) {
        this.Result = Result;
        return this;
    }

    public Integer getID() {return ID;}
    public String getType() {
        return Type;
    }
    public Integer getFirst() {return FirstNumber;}
    public Integer getSecond() {return SecondNumber;}
    public List<List<Integer>> getStep() {return Step;}
    public Integer getResult() {
        return Result;
    }


}
