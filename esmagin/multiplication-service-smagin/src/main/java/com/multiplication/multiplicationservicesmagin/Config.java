package com.multiplication.multiplicationservicesmagin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Value(value = "#{8082}")
    private Integer port;
}
