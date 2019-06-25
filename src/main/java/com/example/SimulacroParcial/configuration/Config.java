package com.example.SimulacroParcial.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class Config {

    Integer CORE_POOL_SIZE = 1;
    Integer MAX_POOL_SIZE = 50;
    Integer QUEUE_CAPACITY = 100;


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean ("threadPoolTaskExecutor")
    public Executor asyncExecutor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.initialize();

        return executor;
    }
}
