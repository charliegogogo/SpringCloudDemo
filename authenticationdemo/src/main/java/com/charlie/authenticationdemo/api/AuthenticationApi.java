package com.charlie.authenticationdemo.api;

import com.charlie.authenticationdemo.base.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSort;
import io.swagger.annotations.ApiSort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  权限模块前端控制器
 * </p>
 *
 * @author charlie
 * @since 2022-07-21
 */
@Slf4j
@RestController
@ApiSort(value = 1)
@Api(tags = "1.权限接口", value = "权限接口")
@RequestMapping("/authentication")
public class AuthenticationApi {

    @ApiOperation(
            value = "1.1 测试接口",
            notes = "30000:测试接口成功; "
    )
    @ApiOperationSort(value = 1)
    @GetMapping("/test")
    public ApiResponse<String> test(@RequestParam String str) {
        if ("1".equals(str)) {
            //制造一个异常
            throw new NullPointerException();
        }
        return ApiResponse.<String>builder()
                .code(30000)
                .data(str)
                .build();
    }

}
