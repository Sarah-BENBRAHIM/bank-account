package main.java.com.github.bank.account;

import java.io.PrintStream;

/**
 * Created by sbenbrahi on 21/06/2018.
 */
public class Operation {

    private Transaction transaction;
    private Amount amount;

    public Operation(Transaction transaction, Amount amount) {
        this.amount = amount;
        this.transaction = transaction;
    }

    public void printOperation(PrintStream printer) {
        this.transaction.printTransaction(printer, amount);
    }
}
