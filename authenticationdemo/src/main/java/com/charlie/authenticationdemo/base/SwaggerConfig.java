package com.charlie.authenticationdemo.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("Charlie",
                "https://github.com/charliegogogo",
                "charliegogogo338@gmail.com");
        return new ApiInfo(
                "权限管理项目", // 标题
                "权限管理项目描述", // 描述
                "V1.0", // 版本
                "https://github.com/charliegogogo", // 组织链接
                contact, // 联系人信息
                "", // 许可
                "", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

}
