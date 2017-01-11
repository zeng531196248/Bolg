package cn.tbnb1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
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
}
