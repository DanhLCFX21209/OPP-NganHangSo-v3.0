package vn.funix.FX21209.java.asm03.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    @Before
    public void setup() {
        account = new Account("123456", 100000);
    }

    @Test
    public void isPremium() {
        assertTrue(account.isPremium());
    }

    @Test
    public void isAccountNumber() {
        assertTrue(account.isAccountNumber("123455"));
        assertFalse(account.isAccountNumber("123abc"));
    }

}