package service.prototype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

public interface IAccountService {
	//业务方法
	void transfer(Account from,Account to,int balance);
	//查询账号	
	@MiniPager(tableName="account")
	Account searchAccount(int id);
	//分页查询账户账号信息
	@MiniPager(tableName="account")
	List<Account> listAccount(int pageNo,int pageSize);
}
