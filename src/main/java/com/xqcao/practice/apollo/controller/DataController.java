package com.xqcao.practice.apollo.controller;

import com.xqcao.practice.apollo.model.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {

    private final TestBean testBean;

    public DataController(TestBean testBean) {
        this.testBean = testBean;
    }

    @GetMapping
    public TestBean getVariable() {
        return testBean;
    }
}
