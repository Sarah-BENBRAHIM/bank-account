package test.java.com.github.bank.account;

import main.java.com.github.bank.account.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sbenbrahi on 24/06/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class AmountTest {

    @Test
    public void equal_to_ok() {
        Amount amount1 = new Amount(1000);
        Amount amount2 = new Amount(1000);
        assertThat(amount1, is(equalTo(amount2)));
    }

    @Test
    public void sum_ok() {
        Amount amount1 = new Amount(1000);
        Amount amount2= new Amount(1000);
        Amount amount3 = new Amount(2000);
        assertThat(amount3, is(equalTo(amount2.somme(amount1))));
    }

    @Test
    public void greater_than_ok() {
        Amount amount1 = new Amount(1000);
        Amount amount2 = new Amount(100);
        assertThat(amount1.isGreaterThan(amount2), is(true));
    }

    @Test
    public void not_greater_than_ok() {
        Amount amount1 = new Amount(1000);
        Amount amount2 = new Amount(100);
        assertThat(amount2.isGreaterThan(amount1), is(false));
    }

    @Test
    public void absolute_value_ok() {
        Amount minus = new Amount(-10);
        assertThat(new Amount(10), is(equalTo(minus.absoluteValue())));
    }

    @Test public void negative_value_ok() {
        Amount amount = new Amount(10);
        assertThat(new Amount(-10), is(equalTo(amount.getNegativeValue())));
    }
}
