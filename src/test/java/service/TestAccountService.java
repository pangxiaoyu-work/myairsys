package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ApplicationConfig;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class})
public class TestAccountService {
	@Autowired
	private IAccountService actservice;
	@Test
	public void testfind() {
		Account act = actservice.searchAccount(2);
		System.out.println(act);
	}
	@Test
	public void testfindall() {
		Pager<Account> act = (Pager<Account>)actservice.listAccount(1, 5);
		for (Account account : act.getDate()) {
			System.out.println(account);
		}
		System.out.println(act.getTotal());
	}
}
