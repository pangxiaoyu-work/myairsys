package dao.prototype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

public interface AccountDao {
	//-- 把con传过去，就可以在一个事务里面弄
		
	void insert(Account act);
	
	void delete(int id);
		
	Account find(int id);
	
	Pager<Account> findPage(int offset,int pageSize);
	//-- 只返回了数据，做分页查询只有数据是不够的
	List<Account> find(int offset,int pageSize);//-- Integer.MaxValue()
	
	List<Account> findAll();
	//-- 获取总条目数
	int totalItems();
}
