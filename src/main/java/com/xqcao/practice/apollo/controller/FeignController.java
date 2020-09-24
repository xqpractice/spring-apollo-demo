package com.xqcao.practice.apollo.controller;

import com.xqcao.practice.apollo.feign.FeignOriginClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignController {
    private final FeignOriginClient originClient;

    public FeignController(FeignOriginClient originClient) {
        this.originClient = originClient;
    }

    @GetMapping("/hello")
    public String hello() {
        return String.format("Feign message from origin: %s", originClient.hello());
    }

    @GetMapping("/test")
    public String test() {
        return "Feign test";
    }
}
