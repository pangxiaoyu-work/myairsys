package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 数据库的配置
 * 		告诉在哪里找配置信息
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
	//-- 1.获取配置信息
	@Value("${jdbc.driverClass}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	//-- 2.数据库连接池对象
	@Bean(name="dataSource")
	public DataSource createDataSource() {
		DruidDataSource ds = new DruidDataSource();//-- c3p0(hibernate) | alibaba    druid
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		//System.out.println(username);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	//-- 配置JDBCTemplate
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(DataSource ds) {//-- 依赖注入，自动注入
		//-- 利用数据源构造JdbcTemplate
		return new JdbcTemplate(ds);
	}
}
