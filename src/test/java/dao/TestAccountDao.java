package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ApplicationConfig;
import dao.prototype.AccountDao;
import entity.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class})
public class TestAccountDao {
	@Autowired
	private AccountDao accountDao;
	@Test
	public void testAccountFind() {
		Account act = accountDao.find(2);
		System.out.println(act);
	}
	@Test
	public void testAccountFindAll() {
		List<Account> act = accountDao.findAll();
		System.out.println(act);
	}
}
