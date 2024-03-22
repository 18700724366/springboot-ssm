package xian.woniuxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("xian.woniuxy.mapper")
@ServletComponentScan
@EnableCaching
@EnableSwagger2
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}