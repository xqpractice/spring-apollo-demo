package com.xqcao.practice.apollo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestBean {
    @Value("${com.practice.bean.test.name:'default name'}")
    private String name;
    @Value("${com.practice.bean.test.value:0}")
    private Integer value;
}
