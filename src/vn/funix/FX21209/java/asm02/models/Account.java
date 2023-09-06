package vn.funix.FX21209.java.asm02.models;

public class Account {
    private String accountNumber;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if(isAccountNumber(accountNumber)) {
            this.accountNumber = accountNumber;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    // check isPremium for Account
    public boolean isPremium() {
        if(this.balance >= 10000000) {
            return true;
        }

        return false;
    }
    // check accountNumber for 6 number
    public static boolean isAccountNumber(String accountNumber) {
        if(accountNumber.length() == 6 && accountNumber.matches("[0-9]+")) {
            return true;
        }
        return false;
    }
    // display account information
    public String toString() {
        return accountNumber + " |\t\t\t\t\t\t" + String.format("%,d", (long) getBalance()) + "đ";
    }
}
