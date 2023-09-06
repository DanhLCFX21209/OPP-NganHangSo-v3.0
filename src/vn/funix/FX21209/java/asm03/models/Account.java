package vn.funix.FX21209.java.asm03.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transaction;
    private double transactionFee;
    private static final Utils utils = new Utils();

    public Account(String accountNumber, double balance) {
        if(isAccountNumber(accountNumber)) {
            this.accountNumber = accountNumber;
        }
        this.balance = balance;
        this.transaction = new ArrayList<>();
        getTransactionFee();
        this.transaction.add(new Transaction(accountNumber, this.balance, new Date()));
    }

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

    public double getTransactionFee() {
        double transactionFee;
        if(isPremium()) {
            return transactionFee = 0.01;
        } else {
            return transactionFee = 0.05;
        }
    }

    public void setTransactionFee() {

    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    // add Transaction history
    public boolean addTransaction(double amount) {
        if(balance + amount >= 50000) {
            transaction.add(new Transaction(accountNumber, amount, new Date()));
            return true;
        }
        return false;
    }
    // display Transaction history
    public void displayTransaction() {
        String outputFormat = "dd/MM/yyyy HH:mm:ss";

        SimpleDateFormat outputFormatter = new SimpleDateFormat(outputFormat);

        for(int i=0; i<transaction.size(); i++) {
            System.out.println("[GD]\t" + transaction.get(i).getAccountNumber() + " | " + String.format("%,d",(long)transaction.get(i).getAmount()) +"đ" + "\t\t\t\t\t\t" + outputFormatter.format(transaction.get(i).getTime()));
        }
    }

}
