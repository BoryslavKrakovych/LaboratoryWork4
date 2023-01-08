package com.example.laboratoryworkjava4.controller;

import com.example.laboratoryworkjava4.dao.Repository;
import com.example.laboratoryworkjava4.dto.GreatestCommonDivisiorRequest;
import com.example.laboratoryworkjava4.service.FirstNumber;
import com.example.laboratoryworkjava4.service.GreatestCommonDivisiorService;
import com.example.laboratoryworkjava4.service.SecondNumber;
import com.example.laboratoryworkjava4.model.GreatestCommonDivisiorResult;
import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Validated
@RestController
@AllArgsConstructor
public class GreatestCommonDivisionController {
    private final GreatestCommonDivisiorService service;
    private final Repository repository;




    @GetMapping(value = "/getBy/{id}", produces = "application/json")
    public ResponseEntity<?> getbyid(@PathVariable Integer id) {

        GreatestCommonDivisiorResult response = Repository.getResponse(id);
        return ResponseEntity.ok(Objects.requireNonNullElse(response, "id не знайдено"));


    }

    @PostMapping(value = "/solveGCD", produces = "application/json")
    public ResponseEntity<?> solve(@RequestBody @Valid GreatestCommonDivisiorRequest request) {
        final var InputFirst = request.getFirstNumber();
        final var First = new FirstNumber(InputFirst);
        final var InputSecond = request.getSecondNumber();
        final var Second = new SecondNumber(InputSecond);
        final GreatestCommonDivisiorResult response = request.getSteps()
        ? service.gcdWithSteps(First,Second)
        : service.gcdWithoutSteps(First,Second);


        repository.saveFile(response);
        return ResponseEntity.ok(response);

    }

}
