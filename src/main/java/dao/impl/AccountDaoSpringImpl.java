package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.AccountDao;
import entity.Account;
import util.Pager;

@Repository("accountDaoSpringImpl")
public class AccountDaoSpringImpl implements AccountDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void insert(Account act) {
		jdbcTemplate.update("insert into account(name,balance) values(?,?)",new Object[] {act.getName(),act.getBalance()});
	}
	@Override
	public void delete(int id) {
		jdbcTemplate.update("delete from account where id = ?", new Object[] {id});
	}
	@Override
	public Account find(int id) {
		Object[] val = {id};
		//-- sql  参数   转化规则
		return jdbcTemplate.queryForObject("select * from Account where id = ?",val, new BeanPropertyRowMapper<>(Account.class));
		//return (Account)jdbcTemplate.queryForObject("select * from account where id = ?",val, new BeanPropertyRowMapper<Account>(Account.class));
	}
	@Override
	public List<Account> findAll() {
		return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
	}
	@Override
	public Pager<Account> findPage(int offset, int pageSize) {
		return null;
	}
	@Override
	public List<Account> find(int offset, int pageSize) {
		return jdbcTemplate.query("select * from account limit ?,?", new Object[] {offset,pageSize},new BeanPropertyRowMapper<Account>(Account.class));
	}
	@Override
	public int totalItems() {
		return 0;
	}
}