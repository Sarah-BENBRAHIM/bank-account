package test.java.com.github.bank.account;

import main.java.com.github.bank.account.Account;
import main.java.com.github.bank.account.AccountStatement;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date depositDate = formatter.parse("23/06/2018");
            int accountStatementPreviousSize = accountStatement.getOperations().size();
            account.deposit(Float.valueOf(500), depositDate);
            assertEquals(accountStatementPreviousSize + 1, accountStatement.getOperations().size());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void withdraawal_ok() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date depositDate = formatter.parse("23/06/2018");
            int accountStatementPreviousSize = accountStatement.getOperations().size();
            account.deposit(Float.valueOf(200), depositDate);
            assertEquals(accountStatementPreviousSize + 1, accountStatement.getOperations().size());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void statement_printing_ok() {
    }
}
