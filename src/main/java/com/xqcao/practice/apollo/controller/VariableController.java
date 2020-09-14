package com.xqcao.practice.apollo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/variable")
public class VariableController {
    @Value("${com.practice.variable:default}")
    private String variable;

    @GetMapping
    public String getVariable() {
        return "I come from variable: " + variable;
    }
}
