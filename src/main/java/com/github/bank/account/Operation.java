package main.java.com.github.bank.account;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sbenbrahi on 21/06/2018.
 */
public class Operation {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private float amount;
    private Date dateOperation;
    private String EMPTY_BOX = "                              "; // length of an empty box = 30 car
    private int LENGTH = 30;
    private String WHITE_SPACE = " ";
    private String SEPARATOR = "|";

    public Operation(float amount, Date dateOperation) {
        this.amount = amount;
        this.dateOperation = dateOperation;
    }

    public void printTo(PrintStream printer) {
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        builder.append(formatter.format(this.dateOperation));
        if (amount > 0) {
            builder.append(formatValue(Float.toString(amount))
                    .append(SEPARATOR)
                    .append(EMPTY_BOX));
        } else {
            builder.append(EMPTY_BOX)
                    .append(SEPARATOR)
                    .append(formatValue(Float.toString(amount)));
        }
        builder.append(SEPARATOR);
        printer.println(builder.toString());
    }

    private StringBuilder formatValue(String value){
        StringBuilder str = new StringBuilder();
        if (value != null) {
            int l = value.length();
            str.append(WHITE_SPACE).append(value);
            for (int i = 0; i < LENGTH-l-1; i++) {
                str.append(WHITE_SPACE);
            }
            return str;
        }
        return str.append(EMPTY_BOX);
    }
}
