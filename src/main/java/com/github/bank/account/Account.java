package main.java.com.github.bank.account;

import java.util.Date;

/**
 * Created by sbenbrahi on 21/06/2018.
 */
public class Account {

    private AccountStatement accountStatement;

    public Account(AccountStatement accountStatement){
        this.accountStatement = accountStatement;
    }

    public void deposit(Float value, Date date) {
        Operation deposit = new Operation(value, date);
        accountStatement.addOperation(value, date);
    }

    public void withdrawal(Float value, Date date) {
        Operation deposit = new Operation(value, date);
        accountStatement.addOperation(value, date);
    }

}
