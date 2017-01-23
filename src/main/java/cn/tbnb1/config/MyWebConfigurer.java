package cn.tbnb1.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Component  
public class MyWebConfigurer  extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/attached/**").addResourceLocations("classpath:/attached/");
        super.addResourceHandlers(registry);
    }
}
