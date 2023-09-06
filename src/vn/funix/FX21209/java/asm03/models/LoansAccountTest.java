package vn.funix.FX21209.java.asm03.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoansAccountTest {
    LoansAccount loansAccount;

    @Before
    public void setup() {
        loansAccount = new LoansAccount("123456", 8000000);
    }


    @Test
    public void withdraw() {
        assertTrue(loansAccount.withdraw(100000));
        assertTrue(loansAccount.withdraw(1000000));
    }

    @Test
    public void isAccepted() {
        assertFalse(loansAccount.isAccepted(10000000));
        assertTrue(loansAccount.isAccepted(1000000));
    }
}