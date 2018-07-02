package com.github.bank.account;

/**
 * Created by sbenbrahi on 24/06/2018.
 */
public class Amount {

    private int value;

    public Amount(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        Amount amount = (Amount) obj;
        if (value != amount.value)
            return false;
        return true;
    }

    public Amount somme(Amount amount) {
        Amount res = new Amount(this.value + amount.value);
        return res;
    }

    public boolean isGreaterThan(Amount amount) {
        return this.value > amount.value;
    }

    public Amount absoluteValue() {
        Amount res = new Amount(Math.abs(value));
        return res;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public Amount getNegativeValue() {
        Amount res = new Amount(-value);
        return res;
    }
}
