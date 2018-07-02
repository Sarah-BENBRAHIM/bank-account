package test.java.com.github.bank.account;


import com.github.bank.account.Amount;
import com.github.bank.account.Transaction;
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
    public void equal_to_transaction_ok_when_amount_is_equal_to_1000() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date transactionDate = formatter.parse("24/06/2018");
        Transaction depositOfOneThousand = new Transaction(new Amount(1000), transactionDate);
        Transaction anotherDepositOfOneThousand = new Transaction(new Amount(1000), transactionDate);
        assertThat(depositOfOneThousand, is(equalTo(anotherDepositOfOneThousand)));
    }

    @Test
    public void should_print_credit_trasanction_ok_when_amount_is_equal_to_1000() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date transactionDate = formatter.parse("24/06/2018");
        Transaction transaction = new Transaction(new Amount(1000), transactionDate);
        transaction.printTransaction(printer, new Amount(3000));
        verify(printer).println(" 24/06/2018                   | 1000                         |                              | 3000                         |");
    }

    @Test
    public void should_print_debit_trasanction_ok_when_amount_is_equal_to_500() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date transactionDate = formatter.parse("24/06/2018");
        Transaction transaction = new Transaction(new Amount(-500), transactionDate);
        transaction.printTransaction(printer, new Amount(3000));
        verify(printer).println(" 24/06/2018                   |                              | 500                          | 3000                         |");
    }
}
