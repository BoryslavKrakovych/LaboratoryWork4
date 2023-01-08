package com.example.laboratoryworkjava4.dto;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;


public class GreatestCommonDivisiorRequest {
    private int Id;
    private int FirstNumber;
    private int SecondNumber;

    @NotNull
    private Boolean Steps;
    public GreatestCommonDivisiorRequest(int Id,int FirstNumber, int SecondNumber, boolean Steps) {
        this.Id = Id;
        this.FirstNumber = FirstNumber;
        this.SecondNumber = SecondNumber;
        this.Steps = Steps;
    }

    public GreatestCommonDivisiorRequest(int Id) {
        this.Id = Id;
    }


    public Integer getFirstNumber() {
        return FirstNumber;
    }
    public Integer getSecondNumber() {
        return SecondNumber;
    }
    public Integer getId() {
        return Id;
    }
    public Boolean getSteps() {
        return Steps;
    }



}
