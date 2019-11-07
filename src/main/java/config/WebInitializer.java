package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * tomcat启动时，会检测是否有这个实现了 WebApplicationInitializer 接口的类
 * 若检测到有，就会实例化它，并调用他的onStartup()方法
 */
public class WebInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("==========================");
		// 构造Spring容器
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		// Spring容器加载配置
		ctx.register(ApplicationConfig.class);
		// Spring容器接管ServletContext应用上下文对象
		ctx.setServletContext(servletContext);
		// 添加Servlet(至少添加一个servlet,Spring框架实现的入口Servlet)
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}
//-- 要想使用Spring，就得有Spring容器的实例
//-- 要想使用Spring MVC，就得有DispatcherServlet的实例
//-- 还要把这两个东西放到ServletContext中---重量级对象