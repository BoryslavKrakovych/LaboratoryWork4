package com.example.laboratoryworkjava4.service;

import com.example.laboratoryworkjava4.model.GreatestCommonDivisiorResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GreatestCommonDivisiorServiceimpl implements GreatestCommonDivisiorService{

    @Override
    public GreatestCommonDivisiorResult gcdWithSteps(FirstNumber InputFirst, SecondNumber InputSecond) {
        final List<List<Integer>> step = new ArrayList<>();
        int n1 = InputFirst.FirstNumber();
        int n2 = InputSecond.SecondNumber();

        if (n1 <= 0 || n2 <= 0) {
            throw new ArithmeticException();
        }
        step.add(List.of(n1, n2));
        while(n1!=n2)
        {
            if(n1>n2)
                n1=n1-n2;
            else
                n2=n2-n1;
            step.add(List.of(n1, n2));
        }
        final var result = n2;
        return new GreatestCommonDivisiorResult().Type("WithSteps").FirstNumber(InputFirst.FirstNumber()).SecondNumber(InputSecond.SecondNumber()).Result(result).Step(step);
    }


    @Override
    public GreatestCommonDivisiorResult gcdWithoutSteps(FirstNumber InputFirst, SecondNumber InputSecond) {
        int n1 = InputFirst.FirstNumber();
        int n2 = InputSecond.SecondNumber();

        if (n1 <= 0 || n2 <= 0) {
            throw new ArithmeticException();
        }
        while(n1!=n2)
        {
            if(n1>n2)
                n1=n1-n2;
            else
                n2=n2-n1;
        }
        final var result = n2;
        return new GreatestCommonDivisiorResult().Type("WithoutSteps").FirstNumber(InputFirst.FirstNumber()).SecondNumber(InputSecond.SecondNumber()).Result(result);
    }
}
