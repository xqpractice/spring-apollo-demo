package com.xqcao.practice.apollo.controller.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/feign-two")
public class FeignTwoController {

    @GetMapping("/hello")
    public String getOriginOne() {
        return "Origin Feign two";
    }
}
