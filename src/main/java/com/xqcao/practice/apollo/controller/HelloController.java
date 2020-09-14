package com.xqcao.practice.apollo.controller;

import com.xqcao.practice.apollo.response.HelloResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public HelloResponse getHelloWorld() {
        log.info("I'm info message");
        log.debug("I'm debug message");
        return new HelloResponse("world", "I'm apollo demo service");
    }
}
