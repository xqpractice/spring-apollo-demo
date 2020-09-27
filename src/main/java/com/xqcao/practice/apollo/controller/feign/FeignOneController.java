package com.xqcao.practice.apollo.controller.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/feign-one")
public class FeignOneController {

    @GetMapping("/hello")
    public String getHello() {
        return "Origin Feign One";
    }
}
