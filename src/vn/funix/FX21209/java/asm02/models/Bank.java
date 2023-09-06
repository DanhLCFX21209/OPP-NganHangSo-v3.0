package vn.funix.FX21209.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private String id;
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    // add Customer
    public boolean addCustomer(String name, String customerId) {
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setCustomerId(customerId);
        if(!isCustomerExisted(customerId)) {
            this.customers.add(newCustomer);
            return true;
        }

        return false;
    }
    // add Account
    public boolean addAccount(String customerId, String accountNumber, double balance) {
        Account newAccount = new Account();
        newAccount.setAccountNumber(accountNumber);
        newAccount.setBalance(balance);
        Customer cus = searchCustomerByCCCD(customerId);
        if(cus != null) {
           return cus.addAccount(accountNumber, balance);
        }

        return false;
    }
    // check Is the Customer premium
    public boolean isCustomerExisted(String customerId) {
        for(int i=0;i< customers.size(); i++) {
            if(this.customers.get(i).getCustomerId().equals(customerId)) {
                return true;
            }
        }

        return false;
    }
    // search Customer by CCCD
    public Customer searchCustomerByCCCD(String customerId) {
        for(int i=0; i<customers.size(); i++) {
            if(this.customers.get(i).getCustomerId().equals(customerId)) {
                return this.customers.get(i);
            }
        }

        return null;
    }
    //search Customers by name
    public void searchCustomerByName(String name) {
        for(int i=0; i<customers.size(); i++) {
            if(this.customers.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                this.customers.get(i).displayInformation();
            }
        }
    }
    // display list information
    public void ListdisplayInformations() {
        for(int i=0; i<this.customers.size(); i++) {
            this.customers.get(i).displayInformation();
        }
    }


}
