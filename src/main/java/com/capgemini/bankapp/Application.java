package com.capgemini.bankapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exceptions.LowBalanceException;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	BankAccount account1=new BankAccount(109,"nandu","savings",10000);
		BankAccountController bankAccountController=
			context.getBean("bankAccountController",BankAccountController.class);
//	System.out.println(bankAccountController.getBalance(105));
//	try {
//bankAccountController.fundTransfer(106, 107, 50);
//System.out.println(bankAccountController.getBalance(106));
//bankAccountController.addBankAccount(account1);

System.out.println(bankAccountController.getBalance(109));

//bankAccountController.deleteBankAccount(108);
/*bankAccountController.addBankAccount(account);
System.out.println(bankAccountController.getBalance());*/
/*bankAccountController.withdraw(108, 100);
System.out.println(bankAccountController.getBalance(108));*/

/*bankAccountController.updateBalance(106, 500);
System.out.println(bankAccountController.getBalance(106)); */
System.out.println(bankAccountController.updateBankAccount(new BankAccount(109, "nandini", "current", 10000)));
//System.out.println(bankAccountController.findBankAccountById(107));
//System.out.println(bankAccountController.updateBankAccount(account1));
//bankAccountController.deposit(105, 200);
//System.out.println(bankAccountController.getBalance(108));
	
//}catch(LowBalanceException e) {
//	System.out.println(e.getMessage());
//	}

}
}
