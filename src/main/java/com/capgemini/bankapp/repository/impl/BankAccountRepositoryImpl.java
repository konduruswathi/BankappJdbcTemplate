package com.capgemini.bankapp.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.repository.BankAccounRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccounRepository {
//private HashSet<BankAccount> bankAccounts;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

@Override
public double getBalance(long accountId) {
	double balance=jdbcTemplate.queryForObject("SELECT balance FROM bankaccountss WHERE account_id=?", new Object[] {accountId},Double.class);
	return balance;
}

@Override
public boolean updateBalance(long accountId, double newBalance) {
	int count=jdbcTemplate.update("UPDATE bankaccountss SET balance=? WHERE account_id=?", new Object[] {newBalance,accountId});
	return count!=0;
}
@Override
public boolean addBankAccount(BankAccount account) {
	int count=jdbcTemplate.update("INSERT INTO bankaccountss VALUES(?,?,?,?)",new Object[] 
			{account.getAccountId(),account.getAccountHolderName(),account.getAccountType(),account.getAccountBalance()});
	return count!=0;
}
@Override
public BankAccount findBankAccountById(long accountId) {
	return jdbcTemplate.queryForObject("SELECT * FROM bankaccountss WHERE account_id=?",new Object[]{accountId},new BankAccountRowMapper());
	
}

@Override
public List<BankAccount> findAllBankAccounts() {
	
	return jdbcTemplate.query("SELECT * FROM bankaccountss",new Object[] {},new BankAccountRowMapper());
}

@Override
public BankAccount updateBankAccount(BankAccount account) {
	int count=jdbcTemplate.update("UPDATE bankaccountss SET account_holdername=?,account_type=? WHERE account_id=?", new Object[] {account.getAccountHolderName(),account.getAccountType(),account.getAccountId()});
	return count!=0?account:findBankAccountById(account.getAccountId());
	
}

@Override
public boolean deleteBankAccount(long accountId) {
int count=jdbcTemplate.update("DELETE FROM bankaccountss WHERE account_id=?",new Object[] {accountId});
	return count!=0;
}


}
 class BankAccountRowMapper implements RowMapper<BankAccount>{
	

	@Override
	public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {

BankAccount account=new BankAccount();
account.setAccountId(rs.getInt(1));
account.setAccountHolderName(rs.getString(2));
account.setAccountType(rs.getString(3));
account.setAccountBalance(rs.getDouble(4));
		return account;
	}
}


