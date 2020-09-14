package com.xqcao.practice.apollo.controller;

import com.xqcao.practice.apollo.response.HelloResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignController {

    @GetMapping("/origin1")
    public String getOriginOne() {
        return "Origin One";
    }

    @GetMapping("/origin1")
    public String getOriginOne() {
        return "Origin One";
    }
}
