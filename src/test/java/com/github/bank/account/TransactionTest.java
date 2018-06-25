package test.java.com.github.bank.account;

import main.java.com.github.bank.account.Amount;
import main.java.com.github.bank.account.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

/**
 * Created by sbenbrahi on 25/06/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

    @Mock
    PrintStream printer;

    @Test
    public void equal_to_transaction_ok() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date transactionDate = formatter.parse("24/06/2018");
            Transaction depositOfOneHundred = new Transaction(new Amount(1000), transactionDate);
            Transaction anotherDepositOfOneHundred = new Transaction(new Amount(1000), transactionDate);
            assertThat(depositOfOneHundred, is(equalTo(anotherDepositOfOneHundred)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void print_credit_trasanction_ok() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date transactionDate = formatter.parse("24/06/2018");
            Transaction transaction = new Transaction(new Amount(1000), transactionDate);
            transaction.printTransaction(printer, new Amount(3000));
            verify(printer).println(" 24/06/2018                   | 1000                         |                              | 3000                         |");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void print_debit_trasanction_ok() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date transactionDate = formatter.parse("24/06/2018");
            Transaction transaction = new Transaction(new Amount(-500), transactionDate);
            transaction.printTransaction(printer, new Amount(3000));
            verify(printer).println(" 24/06/2018                   |                              | 500                          | 3000                         |");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
