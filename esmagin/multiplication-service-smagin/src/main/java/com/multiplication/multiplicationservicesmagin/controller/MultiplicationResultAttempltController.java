package com.multiplication.multiplicationservicesmagin.controller;

import com.multiplication.multiplicationservicesmagin.model.MultiplicationAttempt;
import com.multiplication.multiplicationservicesmagin.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttempltController {
    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationResultAttempltController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @PostMapping
    ResponseEntity<MultiplicationAttempt> postResult(@RequestBody MultiplicationAttempt multiplicationAttempt){
        boolean isCorrect = multiplicationService.checkAttempt(multiplicationAttempt);
        MultiplicationAttempt attempt =
                new MultiplicationAttempt(multiplicationAttempt.getUser(),
                        multiplicationAttempt.getMultiplication(),
                        multiplicationAttempt.getResultAttempt(),
                        isCorrect);

        return ResponseEntity.ok(attempt);
    }

    @GetMapping
    ResponseEntity<List<MultiplicationAttempt>> getStatistics(@RequestParam("alias") String alias){
        return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
    }
}
