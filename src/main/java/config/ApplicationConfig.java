package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
/**
 * 应用配置(Spring配置) == xml文件
 * 
 */
//@EnableWebMvc
@Configuration
@ComponentScan({"dao","service","util","controller"})
//-- 启动Spring的AOP功能
@EnableAspectJAutoProxy
@Import(JdbcConfig.class)
public class ApplicationConfig {
	/**
	 * jsp的解析器
	 * Bean就是告诉Spring MVC你写的jsp文件的位置
	 */
	/*@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");//位置
		resolver.setSuffix(".jsp");//省略jsp的后缀;
		resolver.setViewClass(JstlView.class);
		return resolver;
	}*/
}