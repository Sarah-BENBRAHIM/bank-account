package main.java.com.github.bank.account;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sbenbrahi on 21/06/2018.
 */
public class AccountStatement {

    public static final String TOP_HEADER = "___________________________________________________________________________________________________________________________";
    public static final String HEADER = "|Date op\u00E9ration               | Cr\u00E9dit                       | D\u00E9bit                        | Total                        |";
    private List<Operation> operations = new LinkedList<Operation>();

    public void addOperation(Transaction transaction, Amount amount) {
        operations.add(0, new Operation(transaction, amount));
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void printAccountStatement(PrintStream printer) {
        StringBuilder header = new StringBuilder();
        header.append(TOP_HEADER).append("\n").append(HEADER).append("\n").append(TOP_HEADER);
        printer.println(header.toString());
        for (Operation operation : operations) {
            operation.printOperation(printer);
        }
    }
}
