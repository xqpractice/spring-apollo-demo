package com.xqcao.practice.apollo.config;

import com.xqcao.practice.apollo.model.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    @Bean
    public TestBean testBean() {
        return new TestBean();
    }
}
