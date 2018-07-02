package com.github.bank.account;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sbenbrahi on 24/06/2018.
 */
public class Transaction {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private String EMPTY_BOX = "                              "; // length of an empty box = 30 car
    private SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
    private int LENGTH = 30;
    private String WHITE_SPACE = " ";
    private String SEPARATOR = "|";

    private Amount amount;
    private Date date;

    public Transaction(Amount amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        Transaction tran = (Transaction) obj;
        if (date == null) {
            if (tran.date != null)
                return false;
        } else if (!date.equals(tran.date))
            return false;
        if (amount == null) {
            if (tran.amount != null)
                return false;
        } else if (!amount.equals(tran.amount))
            return false;
        return true;
    }

    public void printTransaction(PrintStream printer, Amount total) {
        StringBuilder builder = new StringBuilder();
        buildDate(builder);
        buildValue(builder);
        buildTotal(builder, total);
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

    private void buildDate(StringBuilder builder) {
        builder.append(formatValue(formatter.format(date)));
        builder.append(SEPARATOR);
    }

    private void buildValue(StringBuilder builder) {
        if (amount.isGreaterThan(new Amount(0))) {
            Amount absoluteValue = amount.absoluteValue();
            String credit = absoluteValue.toString();
            builder.append(formatValue(credit)
                    .append(SEPARATOR)
                    .append(EMPTY_BOX));
        } else {
            Amount absoluteValue = amount.absoluteValue();
            String debit = absoluteValue.toString();
            builder.append(EMPTY_BOX)
                    .append(SEPARATOR)
                    .append(formatValue(debit));
        }
        builder.append(SEPARATOR);
    }

    public void buildTotal(StringBuilder builder, Amount total){
        builder.append(formatValue(total.toString())
                .append(SEPARATOR));
    }


}
