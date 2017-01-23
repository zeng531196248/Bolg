package cn.tbnb1;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;


/**
 * 
* @ClassName: Tbnb1 
* @Description: 启动入口
* @author tbnb1.cn
* @date 2017年1月11日 下午12:17:58 
*
 */
@SpringBootApplication
public class Tbnb1 {

	public static void main(String[] args) {
		 SpringApplication.run(Tbnb1.class, args);
	}
	
	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
            }
        };
	
	
	}
	@Bean   
    public MultipartConfigElement multipartConfigElement() {   
            MultipartConfigFactory factory = new MultipartConfigFactory();  
            //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;  
            factory.setMaxFileSize("10MB"); //KB,MB  
            /// 设置总上传数据总大小  
            factory.setMaxRequestSize("10MB");   
            //Sets the directory location where files will be stored.  
            //factory.setLocation("路径地址");  
            
            
            return factory.createMultipartConfig();   
    }   
	
	
	
}
