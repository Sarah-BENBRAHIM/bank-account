package test.java.com.github.bank.account;

import main.java.com.github.bank.account.Account;
import main.java.com.github.bank.account.AccountStatement;
import main.java.com.github.bank.account.Amount;
import main.java.com.github.bank.account.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.verify;

/**
 * Created by sbenbrahi on 21/06/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    private Account account;
    @Mock
    private AccountStatement accountStatement;


    @Before
    public void initialise() {
        account = new Account(accountStatement);
    }


    @Test
    public void deposit_ok() {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date depositDate = null;
        try {
            depositDate = formatter.parse("23/06/2018");
            Amount depositAmount = new Amount(1000);

            account.deposit(depositAmount, depositDate);
            Transaction transaction = new Transaction(depositAmount, depositDate);

            verify(accountStatement).addOperation(transaction, depositAmount);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void withdraawal_ok() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date withdrawalDate = formatter.parse("23/06/2018");
            account.withdrawal(new Amount(500), withdrawalDate);
            Transaction transaction = new Transaction(new Amount(-500), withdrawalDate);
            verify(accountStatement).addOperation(transaction, new Amount(-500));
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void statement_printing_ok() {

        PrintStream printer = System.out;

        account.printAccountStatement(printer);

        verify(accountStatement).printAccountStatement(printer);
    }
}
