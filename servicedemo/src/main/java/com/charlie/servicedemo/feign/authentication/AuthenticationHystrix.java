package com.charlie.servicedemo.feign.authentication;

import com.charlie.servicedemo.base.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthenticationHystrix implements AuthenticationClient{

    @Override
    public ApiResponse<String> test(String str) {
        log.error("接口调用失败，进入熔断");
        return null;
    }

}
