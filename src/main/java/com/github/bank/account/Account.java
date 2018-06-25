package main.java.com.github.bank.account;

import java.io.PrintStream;
import java.util.Date;

/**
 * Created by sbenbrahi on 21/06/2018.
 */
public class Account {

    private AccountStatement accountStatement;
    private Amount currentAmount = new Amount(0);

    public Account(AccountStatement accountStatement){
        this.accountStatement = accountStatement;
    }

    public void deposit(Amount amount, Date depositDate) {
        Transaction transaction = new Transaction(amount, depositDate);
        this.currentAmount = this.currentAmount.somme(amount);
        accountStatement.addOperation(transaction, this.currentAmount);
    }

    public void withdrawal(Amount amount, Date depositDate) {
        if (amount.isGreaterThan(new Amount(0))){
            amount = amount.getNegativeValue();
        }
        Transaction transaction = new Transaction(amount, depositDate);
        this.currentAmount = this.currentAmount.somme(amount);
        accountStatement.addOperation(transaction, this.currentAmount);
    }

    public void printAccountStatement(PrintStream printer) {
        accountStatement.printAccountStatement(printer);
    }

}
