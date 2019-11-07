package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.AccountDao;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;

@Service("accountServiceImpl")
public class AccountServiceImpl implements IAccountService{
	@Autowired
	private AccountDao actdao;
	
	//-- Spring 声明的Transaction(事务)处理 --- 原理:AOP动态代理的应用
	@Override
	public void transfer(Account from, Account to, int balance) {
		
	}
	@Override
	public Account searchAccount(int id) {
		return actdao.find(id);
	}
	@Override
	public List<Account> listAccount(int pageNo, int pageSize) {
		//-- 根据页数求条数
		return actdao.find((pageNo-1)*pageSize, pageSize);
	}
}
