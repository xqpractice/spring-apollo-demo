package com.xqcao.practice.apollo.controller;

import com.xqcao.practice.apollo.config.DictionaryConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/dict")
public class DictionaryController {
    private final DictionaryConfig config;

    public DictionaryController(DictionaryConfig config) {
        this.config = config;
    }

    @GetMapping
    public Map<String, Object> getVariable() {
        return config.getDictionary();
    }
}
