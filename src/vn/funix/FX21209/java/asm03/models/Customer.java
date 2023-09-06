package vn.funix.FX21209.java.asm03.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }


    public List<Account> getAccounts() {
        return accounts;
    }
    // check Is the accounts premium
    public boolean isPremium() {
        for (int i=0; i<this.accounts.size(); i++) {
            if(this.accounts.size() >= 1 && this.accounts.get(i).isPremium()) {
                return true;
            }
        }

        return false;
    }
    // add Account
    public boolean addAccount(Account newAccount) {
        String accountNumber = newAccount.getAccountNumber();
        if(isAccount(accountNumber) == null) {
            if(newAccount.getAccountNumber().equals(accountNumber)) {
                this.accounts.add(newAccount);
                return true;
            }
        }

        return false;

    }
    // check if the account exists
    public Account isAccount(String accountNumber) {
        for(int i=0; i<this.accounts.size(); i++) {
            if(this.accounts.get(i).getAccountNumber().equals(accountNumber)) {
                return this.accounts.get(i);
            }
        }
        return null;
    }
    // calculation balance
    public double getBalance() {
        double total =0;
        for(int i=0; i<this.accounts.size(); i++) {
            total += this.accounts.get(i).getBalance();
        }

        return total;
    }
    // display Information
    public void displayInformation() {
        String kt = isPremium() ? "Premium" : "Normal";
        System.out.print(getCustomerId() + " |\t\t");
        System.out.print(getName() + " |\t");
        System.out.print(kt + "| \t");
        System.out.printf("%,d", (long)getBalance());
        System.out.println("đ");
        for(int i=0; i<this.accounts.size(); i++) {
            System.out.println((i+1) + "\t\t" + this.accounts.get(i).toString());
        }
    }

    public void listDisplayTransaction() {
        for(int i=0; i<accounts.size(); i++) {
            accounts.get(i).displayTransaction();
        }
    }


}
