package test.java.com.github.bank.account;


import com.github.bank.account.Account;
import com.github.bank.account.AccountStatement;
import com.github.bank.account.Amount;
import com.github.bank.account.Transaction;
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
    public void should_deposit_ok_when_amount_is_equal_to_1000() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date depositDate =  formatter.parse("23/06/2018");
        Amount depositAmount = new Amount(1000);
        account.deposit(depositAmount, depositDate);
        Transaction transaction = new Transaction(depositAmount, depositDate);
        verify(accountStatement).addOperation(transaction, depositAmount);
    }

    @Test
    public void should_withdraawal_ok_when_amount_is_equal_to_500() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date withdrawalDate = formatter.parse("23/06/2018");
        account.withdrawal(new Amount(500), withdrawalDate);
        Transaction transaction = new Transaction(new Amount(-500), withdrawalDate);
        verify(accountStatement).addOperation(transaction, new Amount(-500));
    }

    @Test
    public void statement_printing_ok() {

        PrintStream printer = System.out;

        account.printAccountStatement(printer);

        verify(accountStatement).printAccountStatement(printer);
    }
}
