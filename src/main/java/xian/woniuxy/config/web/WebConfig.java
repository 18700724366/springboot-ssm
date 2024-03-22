package xian.woniuxy.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xian.woniuxy.converter.MyDateConverter;
import xian.woniuxy.interceptor.A;

import java.text.SimpleDateFormat;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private A a;
    @Autowired
    private MyDateConverter myDateConverter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(a)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/user/save2");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(myDateConverter);
    }

    @Bean
    public HttpMessageConverter httpMessageConverter() {
        MappingJackson2HttpMessageConverter mc = new MappingJackson2HttpMessageConverter();
        mc.getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
        return mc;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
