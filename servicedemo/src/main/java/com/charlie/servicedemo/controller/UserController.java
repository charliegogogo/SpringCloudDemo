package com.charlie.servicedemo.controller;

import com.alibaba.fastjson.JSON;
import com.charlie.servicedemo.base.ApiResponse;
import com.charlie.servicedemo.feign.authentication.AuthenticationClient;
import com.charlie.servicedemo.model.entity.User;
import com.charlie.servicedemo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSort;
import io.swagger.annotations.ApiSort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  用户模块前端控制器
 * </p>
 *
 * @author charlie
 * @since 2022-07-19
 */
@Slf4j
@RestController
@ApiSort(value = 1)
@Api(tags = "1.用户接口", value = "用户接口")
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @Resource
    private AuthenticationClient authenticationClient;

    @ApiOperation(
            value = "1.1 新增用户",
            notes = "30000:新增用户成功; "
    )
    @ApiOperationSort(value = 1)
    @GetMapping("/add")
    public void test() {
        User user = new User();
        user.setName("王老五");
        iUserService.save(user);
    }

    @ApiOperation(
            value = "1.2 测试获取用户信息",
            notes = "30000:新增用户成功; "
    )
    @ApiOperationSort(value = 2)
    @GetMapping("/get")
    public ApiResponse<String> get(@RequestParam String str) {
        ApiResponse<String> response = authenticationClient.test(str);
        String result = "请求authentication返回的结果是: " + JSON.toJSONString(response);
        return ApiResponse.<String>builder()
                .code(30000)
                .data(result)
                .build();
    }

}
