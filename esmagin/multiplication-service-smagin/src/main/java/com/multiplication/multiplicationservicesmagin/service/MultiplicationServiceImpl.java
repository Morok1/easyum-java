package com.multiplication.multiplicationservicesmagin.service;

import com.multiplication.multiplicationservicesmagin.model.MultUser;
import com.multiplication.multiplicationservicesmagin.model.Multiplication;
import com.multiplication.multiplicationservicesmagin.model.MultiplicationAttempt;
import com.multiplication.multiplicationservicesmagin.repository.MultUserRepository;
import com.multiplication.multiplicationservicesmagin.repository.MultiplicationAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
    private RandomGeneratorService randomGeneratorService;
    private MultiplicationAttemptRepository multiplicationAttemptRepository;
    private MultUserRepository multUserRepository;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService,
                                     MultiplicationAttemptRepository multiplicationAttemptRepository,
                                     MultUserRepository multUserRepository) {
        this.randomGeneratorService = randomGeneratorService;
        this.multiplicationAttemptRepository = multiplicationAttemptRepository;
        this.multUserRepository = multUserRepository;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.getRandomFactor();
        int factorB = randomGeneratorService.getRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    @Transactional
    public boolean checkAttempt(MultiplicationAttempt resultAttempt) {
        Optional<MultUser> user = multUserRepository.findByAlias(resultAttempt.getUser().getAlias());
        Assert.isTrue(!resultAttempt.isCorrect(), "Your attempt is wrong! Please try again!");

        boolean isCorrect =  resultAttempt.getResultAttempt() ==
                resultAttempt.getMultiplication().getFactorA() *
                resultAttempt.getMultiplication().getFactorB();
        MultiplicationAttempt checkedAttempt = new MultiplicationAttempt(
                user.orElse(resultAttempt.getUser()),
                resultAttempt.getMultiplication(),
                resultAttempt.getResultAttempt(),
                isCorrect);
        multiplicationAttemptRepository.save(checkedAttempt);
        return isCorrect;
    }

    @Override
    public List<MultiplicationAttempt> getStatsForUser(String alias) {
        return multiplicationAttemptRepository.findTop5ByUserAliasOrderByIdDesc(alias);
    }
}
