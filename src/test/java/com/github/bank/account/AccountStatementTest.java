package test.java.com.github.bank.account;

import main.java.com.github.bank.account.AccountStatement;
import main.java.com.github.bank.account.Amount;
import main.java.com.github.bank.account.Operation;
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
 * Created by sbenbrahi on 24/06/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountStatementTest {

    @Mock
    PrintStream printer;
    @Mock
    Transaction transaction;
    private AccountStatement accountStatement;

    @Before
    public void initialise() {
        accountStatement = new AccountStatement();
    }

    @Test
    public void print_header_ok() {
        accountStatement.printAccountStatement(printer);
        StringBuilder header = new StringBuilder();
        header.append(AccountStatement.TOP_HEADER).append("\n").append(AccountStatement.HEADER).append("\n").append(AccountStatement.TOP_HEADER);
        verify(printer).println(header.toString());
    }

    @Test
    public void print_deposit_ok() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date depositDate = null;
        try {
            depositDate = formatter.parse("24/06/2018");
            Transaction transaction = new Transaction(new Amount(1000), depositDate);
            Operation depositOperation = new Operation(transaction, new Amount(3000));
            depositOperation.printOperation(printer);
            verify(printer).println(" 24/06/2018                   | 1000                         |                              | 3000                         |");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void print_withdrawal_ok() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date withdrawalDate = null;
        try {
            withdrawalDate = formatter.parse("24/06/2018");
            Transaction transaction = new Transaction(new Amount(-500), withdrawalDate);
            Operation depositOperation = new Operation(transaction, new Amount(3000));
            depositOperation.printOperation(printer);
            verify(printer).println(" 24/06/2018                   |                              | 500                          | 3000                         |");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
