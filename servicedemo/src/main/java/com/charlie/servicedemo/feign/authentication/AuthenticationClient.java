package com.charlie.servicedemo.feign.authentication;

import com.charlie.servicedemo.base.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="authentication-demo", fallback = AuthenticationHystrix.class)
public interface AuthenticationClient {

    @GetMapping("/authentication/test")
    ApiResponse<String> test(@RequestParam String str);

}
