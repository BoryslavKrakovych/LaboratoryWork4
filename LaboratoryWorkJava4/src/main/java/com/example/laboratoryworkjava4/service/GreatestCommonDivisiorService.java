package com.example.laboratoryworkjava4.service;

import com.example.laboratoryworkjava4.model.GreatestCommonDivisiorResult;




public interface GreatestCommonDivisiorService{
    GreatestCommonDivisiorResult gcdWithSteps(FirstNumber InputFirst, SecondNumber InputSecond);
    GreatestCommonDivisiorResult gcdWithoutSteps(FirstNumber InputFirst, SecondNumber InputSecond);
}
