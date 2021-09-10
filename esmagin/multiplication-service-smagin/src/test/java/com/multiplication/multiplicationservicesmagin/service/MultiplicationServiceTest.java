package com.multiplication.multiplicationservicesmagin.service;

import com.multiplication.multiplicationservicesmagin.model.Multiplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

public class MultiplicationServiceTest {
    private MultiplicationService multiplicationService;
    RandomGeneratorService randomGeneratorService =
            Mockito.mock(RandomGeneratorService.class);
    @BeforeAll
    public void setUp(){
        multiplicationService = new MultiplicationServiceImpl(randomGeneratorService,
                null, null);
    }

    @Test
    public void test_createRandomMultiplication(){
        //when
        Mockito.when(randomGeneratorService.getRandomFactor()).thenReturn(3);

        //then
        final Multiplication randomMultiplication = multiplicationService.createRandomMultiplication();

        //assert
        assertNotNull(randomMultiplication);
        assertThat(randomMultiplication.getFactorA(), is(3));
        assertThat(randomMultiplication.getFactorB(), is(3));
    }
}
