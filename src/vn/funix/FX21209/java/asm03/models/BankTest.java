package vn.funix.FX21209.java.asm03.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    private Bank bank;
    private Customer customer;

    @Before
    public void setup() {
        bank = new Bank();
        customer = new Customer();
        customer.setCustomerId("046200004458");
        customer.setName("Danh");
        bank.addCustomer(customer);
    }

    @Test
    public void isCustomerExisted() {
        assertTrue(bank.isCustomerExisted("046200004458"));
        assertFalse(bank.isCustomerExisted("001123456789"));
    }

    @Test
    public void searchCustomerByCCCD() {
        assertEquals(customer, bank.searchCustomerByCCCD("046200004458"));
        assertNotNull(bank.searchCustomerByCCCD("046200004458"));
        assertNull(bank.searchCustomerByCCCD("000123456789"));
    }
}