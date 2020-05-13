package com.Swagger;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //此处根据情况自行添加需要将哪些接口纳入Swagger 文档管理。此处应用basePackage管理，还可以利用注解管理
                //如果填写错误的话会出现“No operations defined in spec!” 的问题。
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(){
        Contact contact = new Contact("GitHub", "https://github.com/Charlottenpl/onepill_service", "1737980290@qq.com");
        return new ApiInfoBuilder()
                .title("OnePill API")
                .description("OnePill服务端接口")
                .termsOfServiceUrl("http://192.168.137.1:8070/onepill/address/list")
                .version("1.0")
                .contact(contact)
                .build();
    }

}