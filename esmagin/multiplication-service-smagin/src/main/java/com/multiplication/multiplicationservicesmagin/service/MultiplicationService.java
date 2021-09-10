package com.multiplication.multiplicationservicesmagin.service;

import com.multiplication.multiplicationservicesmagin.model.MultUser;
import com.multiplication.multiplicationservicesmagin.model.Multiplication;
import com.multiplication.multiplicationservicesmagin.model.MultiplicationAttempt;

import java.util.List;
import java.util.Random;

public interface MultiplicationService {

    Multiplication createRandomMultiplication();

    boolean checkAttempt(final MultiplicationAttempt resultAttempt);

    List<MultiplicationAttempt> getStatsForUser(String alias);

}
