package com.vashchenko.multi2.service;

import com.vashchenko.multi2.model.MultUser;
import com.vashchenko.multi2.model.Multiplication;
import com.vashchenko.multi2.model.MultiplicationAttempt;
import com.vashchenko.multi2.repository.MultUserRepository;
import com.vashchenko.multi2.repository.MultiplicationAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
    private RandomGeneratedService randomGeneratedService;
    private MultiplicationAttemptRepository multiplicationAttemptRepository;
    private MultUserRepository userRepository;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratedService randomGeneratedService,
                                     MultiplicationAttemptRepository multiplicationAttemptRepository,
                                     MultUserRepository userRepository) {
        this.randomGeneratedService = randomGeneratedService;
        this.multiplicationAttemptRepository = multiplicationAttemptRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratedService.getRandomFactor();
        int factorB = randomGeneratedService.getRandomFactor();

        return new Multiplication(factorA, factorB);
    }

    @Override
    @Transactional
    public boolean checkAttempt(MultiplicationAttempt resultAttempt) {
        Optional<MultUser> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());
        Assert.isTrue(!resultAttempt.isCorrect(), "Your attempte is wrong! PLease try Again");
        boolean isCorrect = resultAttempt.getResultAttempt() == resultAttempt.getMultiplication().getFactorA() *
                resultAttempt.getMultiplication().getFactorB();

        MultiplicationAttempt checkAttempt = new MultiplicationAttempt(user.orElse(resultAttempt.getUser()), resultAttempt.getMultiplication(),
                resultAttempt.getResultAttempt(), isCorrect);
        multiplicationAttemptRepository.save(checkAttempt);

        return isCorrect;
    }

    @Override
    public List<MultiplicationAttempt> getStatsForUser(String alias) {
        return multiplicationAttemptRepository.findTop5ByUserAliasOrderByIdDesc(alias);
    }
}
