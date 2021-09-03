package com.vashchenko.multi2.service;

import com.vashchenko.multi2.model.MultUser;
import com.vashchenko.multi2.model.Multiplication;
import com.vashchenko.multi2.model.MultiplicationAttempt;

import java.util.List;

public interface MultiplicationService {
    Multiplication createRandomMultiplication();

    boolean checkAttempt(final MultiplicationAttempt resultAttempt);

    List<MultiplicationAttempt> getStatsForUser(String alias);
}
