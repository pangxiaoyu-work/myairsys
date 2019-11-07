package util;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
/**
 * 配置切面
 * @author 吊车尾
 *
 */
@Aspect
@Component
public class PagerAspect {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//-- service包下的所有类
	@Pointcut("execution(* service..*(..))")
	public void selfPointcut() {}
	
	@Around("selfPointcut()")
	public Object selfAround(ProceedingJoinPoint jp) {
		Object obj = null;
		//-- 获取方法
		MethodSignature ms = (MethodSignature)jp.getSignature();
		Method method = ms.getMethod();
		//-- 方法是否含有@MiniPager标注
		MiniPager minipager = (MiniPager)method.getAnnotation(MiniPager.class);
		if (minipager==null) {
			try {
				obj = jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return obj;
		}
		//获取总条数
		String tablename = minipager.tableName();
		int totalItems = jdbcTemplate.queryForObject("select count(*) from "+tablename, Integer.class);
		//根据页大小计算页的总数
		int pagesize = (int)jp.getArgs()[1];
		int pageNo = (int)jp.getArgs()[0];
		int totalpages = (totalItems + pagesize - 1)/pagesize;
		if (pageNo>totalpages) {
			pageNo = totalpages;
		}
		//返回Pager分页对象
		Pager pager = new Pager();
		try {
			List list = (List)jp.proceed(new Object[] {pageNo,pagesize});
			pager.setDate(list);
			pager.setTotal(totalpages);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return pager;
	}
}
