package com.sl.common.cfg;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Configuration
public class SwaggerCfg implements InitializingBean {
    @Autowired
    private Environment environment;
    private boolean enable;

    @Bean
    public Docket sysDocket() {
        return groupDocket(
                "01_系统",
                "系统模块文档",
                "用户，角色，资源",
                "/sys.*");
    }

    @Bean
    public Docket metadataDocket() {
        return groupDocket(
                "02_元数据",
                "元数据模块文档",
                "数据字典条目，数据字典类型, 省份，城市",
                "/(dict.*|plate.*)");
    }

    @Bean
    public Docket examDocket() {
        return groupDocket(
                "03_考试",
                "考试模块文档",
                "考场，科1科4，科2科3",
                "/exam.*");
    }

    private Docket groupDocket(String group, String title, String description, String regex) {
        return basicDocket()
                .groupName(group)
                .apiInfo(apiInfo(title, description))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.regex(regex))
                .build();
    }

    private Docket basicDocket() {
        RequestParameter token = new RequestParameterBuilder()
                .name("Token")
                .description("用户登录令牌")
                .in(ParameterType.HEADER)
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .globalRequestParameters(List.of(token))
                .ignoredParameterTypes(
                        HttpSession.class,
                        HttpServletRequest.class,
                        HttpServletResponse.class
                )
                .enable(enable);
    }

    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version("1.0.0")
                .build();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        enable = environment.acceptsProfiles(Profiles.of("dev", "test"));
    }
}
