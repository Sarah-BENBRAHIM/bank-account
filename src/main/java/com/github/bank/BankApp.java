package main.java.com.github.bank;

import main.java.com.github.bank.account.Account;
import main.java.com.github.bank.account.AccountStatement;
import main.java.com.github.bank.account.Amount;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by sbenbrahi on 24/06/2018.
 */
public class BankApp {

    public static void main(String[] args) {
        Account account = new Account(new AccountStatement());
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            account.deposit(new Amount(3000), formatter.parse("24/06/2018"));
            account.deposit(new Amount(50), formatter.parse("24/06/2018"));
            account.withdrawal(new Amount(1200), formatter.parse("24/06/2018"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        account.printAccountStatement(System.out);
    }
}
