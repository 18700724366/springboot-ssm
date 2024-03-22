package xian.woniuxy.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.woniuxy.controller", "com.woniuxy.entity"})
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Gao", "http://www.star.com", "64918763@qq.com");
        return new ApiInfoBuilder()
                .title("小星星API接口")
                .description("API接口")
                .contact(contact)
                .version("1.0.0")
                .build();
    }
}
