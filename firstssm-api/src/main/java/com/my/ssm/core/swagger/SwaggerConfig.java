package com.my.ssm.core.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration //声明该类为配置类
@EnableSwagger2 //声明启动Swagger2
/**
 * @author WJ
 * @version 1.0.0
 * @className SwaggerConfig
 * @description swagger启动类
 * @date 2019-06-06 16:30
 */
public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        /*return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.my.ssm.ctl"))
                .build();*/
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 配置了@Api的接口
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                //大标题 title
                "MYSSM API接口",
                //小标题
                "Swagger测试demo",
                //版本
                "0.0.1",
                //termsOfServiceUrl
                "",
                //作者
                "WJ",
                //链接显示文字
                "Blog",
                //网站链接
                "https://www.cnblogs.com/lengbumo/"
        );

        /*return new ApiInfoBuilder()
                //文档说明
                .title("MYSSM API接口")
                //文档版本说明
                .version("1.0.0")
                .build();*/
    }
}
