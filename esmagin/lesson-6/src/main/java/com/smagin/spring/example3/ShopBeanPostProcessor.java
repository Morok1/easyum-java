package com.smagin.spring.example3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

@Component
public class ShopBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(o instanceof Disc){

            Arrays.stream(o.getClass().getDeclaredFields())
                    .filter(v -> checkInjectRandomAnnotation(v))
                    .forEach(v -> injectRandom(v, o));
        }
        return o;
    }

    private boolean checkInjectRandomAnnotation(Field v) {
        System.out.println("Check Inject Random" + "!!!!");

        final Annotation[] declaredAnnotations = v.getDeclaredAnnotations();
        if(declaredAnnotations == null){
            return false;
        }
        final Optional<Annotation> annotation = Arrays.stream(declaredAnnotations)
                .filter(p -> p instanceof InjectRandom)
                .findAny();

        return annotation.isPresent();
    }

    private void injectRandom(Field v, Object o) {
        v.setAccessible(true);
        final int random = new Random().nextInt(100);
        System.out.println("GENERATE RANDOM" + random + "!!!!");
        try {
            v.set(o, random);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
