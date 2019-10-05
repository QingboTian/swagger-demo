package com.tqb.swagger.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @ClassName SwaggerConfig
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/10/3 15:40
 * @Version v1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     *
     * @param environment 验证当前项目处于的环境（如生产 开发 测试等）
     * @return
     */
    @Bean
    public Docket docket(Environment environment){

        /**
         * 可用swagger的环境
         */
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);

        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(apiInfo())
                /**
                 * 设置swagger是否可用 主要用于不同环境
                 */
                .enable(flag)
                .select()
                /**
                 * 只扫描具有RestController注解的类
                 */
                 //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                // .apis(RequestHandlerSelectors.basePackage("com.tqb.swagger"))
                .apis(RequestHandlerSelectors.any())
                /**
                 * 过滤器
                 */
                // .paths()
                //.paths(Predicates.not(PathSelectors.regex("/error.*")))
                // .paths(PathSelectors.regex("/.*"))
                .build();
        return docket;
    }

    /**
     * 接口文档基本信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Swagger的测试接口在线文档",
                "接口文档描述",
                "V1.0",
                "urn:tos",
                contact(),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }

    /**
     * 接口文档编写作者
     * @return
     */
    private Contact contact(){
        return new Contact("bobo", "https://blog.csdn.net/weixin_42061805", "tqb820965236@163.com");
    }

}
