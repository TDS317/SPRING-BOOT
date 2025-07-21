package com.example.HomeWork1_BeanLifeCycle;

import com.example.HomeWork1_BeanLifeCycle.BeanLifeCycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean(destroyMethod = "close") // calls `close()` as well as `@PreDestroy`
    public BeanLifeCycle resourceManager() {
        return new BeanLifeCycle();
    }
}
