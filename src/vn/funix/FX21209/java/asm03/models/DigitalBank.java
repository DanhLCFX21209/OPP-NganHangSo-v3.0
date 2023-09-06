package vn.funix.FX21209.java.asm03.models;

public class DigitalBank extends Bank {
    public DigitalBank() {
        super();
    }

    // search Customer By CCCD
    @Override
    public Customer searchCustomerByCCCD(String customerId) {
        return super.searchCustomerByCCCD(customerId);
    }

    // add Customer
    @Override
    public boolean addCustomer(Customer newCustomer) {
        return super.addCustomer(newCustomer);
    }

    // add Account By SavingsAccount
    public boolean addAccount(String customerId, SavingsAccount newAccount) {
        return super.addAccount(customerId, newAccount);
    }
    // add Account By LoansAccount
    public boolean addAccount(String customerId, LoansAccount newAccount) {
        return super.addAccount(customerId, newAccount);
    }

    // withdraw
    public boolean withdraw(String customerId, String accountNumber, double amount) {
        Customer cus = searchCustomerByCCCD(customerId);
        if(cus != null) {
            if(cus instanceof DigitalCustomer) {
                return ((DigitalCustomer) cus).withdraw(accountNumber, amount);
            }
        }
        return false;
    }

}
