	
Hibernate:做持久化
Spring:

分页框架(AOP的应用)：
	目前流行的：PageHelper
	MiniPager：分页更加简单，不用写代码
		框架能够自动分页：标注和AOP，写标注和切面来实现
	目的：使用标注实现分页；解放程序员；纯的Dao代码；
	实现：
		以结果导向去分析，以程序员用例来分析；
		@MiniPager(tableName="")
	编写步骤：
		编写自定义标注；
		编写切面(核心)；
			启动AOP功能：@EnableAspectJAutoProxy
			编写自定义切面
				自定义切面中的切点
				自定义切面中的通知
			编写通知里面的核心代码(实现通用分页)
				只有在有@MiniPager标注的方法上实现拦截功能;实现分页功能；


