package vn.funix.FX21209.java.asm03.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer();
        customer.addAccount(new Account("123456", 50000));
        customer.addAccount(new Account("789012", 100000));
    }

    @Test
    public void isPremium() {
        assertTrue(customer.isPremium());
    }

    @Test
    public void isAccount() {
        assertNull(customer.isAccount("111111"));
        assertNotNull(customer.isAccount("123456"));
    }

    @Test
    public void getBalance() {
       assertEquals(150000.0, customer.getBalance(), 1);
    }
}