package vn.funix.FX21209.java.asm03.models;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Transaction {
    private String id;
    private String accountNumber;
    private double amount;
    private Date time;
    private boolean status;

    public Transaction(String accountNumber, double amount, Date time) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.time = time;
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTime() {
        return time;
    }


    public void display() {
        String outputFormat = "dd/MM/yyyy HH:mm:ss";

        SimpleDateFormat outputFormatter = new SimpleDateFormat(outputFormat);
        String formattedTime = outputFormatter.format(time);
        System.out.println("[GD]" + accountNumber +"\t" + String.format("%,d", (long) amount) +" \t" + formattedTime);
    }
}
