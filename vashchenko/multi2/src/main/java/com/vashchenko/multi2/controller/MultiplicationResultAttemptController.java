package com.vashchenko.multi2.controller;

import com.vashchenko.multi2.model.MultiplicationAttempt;
import com.vashchenko.multi2.service.MultiplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {
    private final MultiplicationService multiplicationService;


    public MultiplicationResultAttemptController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @PostMapping
    ResponseEntity<MultiplicationAttempt> postResult(@RequestBody MultiplicationAttempt multiplicationAttempt) {
        boolean isCorrect = multiplicationService.checkAttempt(multiplicationAttempt);
        MultiplicationAttempt attempt = new MultiplicationAttempt(multiplicationAttempt.getUser(),
                multiplicationAttempt.getMultiplication(), multiplicationAttempt.getResultAttempt(), isCorrect);

        return ResponseEntity.ok(attempt);
    }

    @GetMapping
    ResponseEntity<List<MultiplicationAttempt>> getSatatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
    }
}
