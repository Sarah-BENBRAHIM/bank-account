package main.java.com.github.bank.account;

import main.java.com.github.bank.account.Operation;

import java.io.PrintStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sbenbrahi on 21/06/2018.
 */
public class AccountStatement {

    public static final String STATEMENT_HEADER = " Date opération               | Débit                        | Crédit                       |";

    private List<Operation> operations = new LinkedList<Operation>();

    public void addOperation(float amount, Date dateOperation) {
        operations.add(0, new Operation(amount, dateOperation));
    }

    public List<Operation> getOperations() {
        return operations;
    }

    private void printStatement(PrintStream printer) {
        for (Operation operation : operations) {
            operation.printTo(printer);
        }
    }
}
