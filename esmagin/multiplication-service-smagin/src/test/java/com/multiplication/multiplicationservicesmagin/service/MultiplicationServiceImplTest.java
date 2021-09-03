package com.multiplication.multiplicationservicesmagin.service;

import com.multiplication.multiplicationservicesmagin.model.MultUser;
import com.multiplication.multiplicationservicesmagin.model.Multiplication;
import com.multiplication.multiplicationservicesmagin.model.MultiplicationAttempt;
import com.multiplication.multiplicationservicesmagin.repository.MultUserRepository;
import com.multiplication.multiplicationservicesmagin.repository.MultiplicationAttemptRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

public class MultiplicationServiceImplTest {
    private MultiplicationService multiplicationService;
    @Mock
    private RandomGeneratorService randomGeneratorService;

    @Mock
    private MultiplicationAttemptRepository multiplicationAttemptRepository;

    @Mock
    private MultUserRepository multUserRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        multiplicationService = new MultiplicationServiceImpl(randomGeneratorService, multiplicationAttemptRepository, multUserRepository);
    }

    @Test
    public void createRandomMultiplication() {
        //given
        given(randomGeneratorService.getRandomFactor()).willReturn(50, 30);

        //when
        Multiplication randomMultiplication = multiplicationService.createRandomMultiplication();

        //then
        assertThat(randomMultiplication.getFactorA(), is(50));
        assertThat(randomMultiplication.getFactorB(), is(30));

    }

    @Test
    public void checkWrongAttempt() {
        Multiplication multiplication = new Multiplication(50, 60);
        MultUser user = new MultUser("Ivan");
        MultiplicationAttempt attempt = new MultiplicationAttempt(user, multiplication, 3010, false);
        given(multUserRepository.findByAlias("Ivan")).willReturn(Optional.empty());

        //when
        boolean res = multiplicationService.checkAttempt(attempt);

        assertFalse(res);
        verify(multiplicationAttemptRepository).save(attempt);
    }

    @Test
    public void checkSuccessAttempt() {
        Multiplication multiplication = new Multiplication(50, 60);
        MultUser user = new MultUser("Ivan");
        MultiplicationAttempt attempt = new MultiplicationAttempt(user, multiplication, 3000, false);
        given(multUserRepository.findByAlias("Ivan")).willReturn(Optional.empty());

        //when
        boolean res = multiplicationService.checkAttempt(attempt);

        assertTrue(res);
        verify(multiplicationAttemptRepository).save(attempt);
    }}