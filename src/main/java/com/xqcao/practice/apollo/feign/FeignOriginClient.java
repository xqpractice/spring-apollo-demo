package com.xqcao.practice.apollo.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign-service", url = "${local.server}")
public interface FeignOriginClient {

    @GetMapping("/hello")
    String hello();
}
