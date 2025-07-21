package com.example.HomeWork1_BeanLifeCycle;
import com.example.HomeWork1_BeanLifeCycle.BeanLifeCycle;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class BeanService {
    private final BeanLifeCycle beanLifeCycle;

    public BeanService(BeanLifeCycle resourceManager) {
        this.beanLifeCycle = resourceManager;
        System.out.println("MyService constructor injected ResourceManager.");
    }

    @PostConstruct
    public void start() {
        System.out.println("MyService is starting work...");
        beanLifeCycle.doWork();
    }
}
