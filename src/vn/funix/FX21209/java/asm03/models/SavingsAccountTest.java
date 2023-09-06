package vn.funix.FX21209.java.asm03.models;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    SavingsAccount savingsAccount;

    @Before
    public void setup() {
        savingsAccount = new SavingsAccount("1234567890", 8000000);
    }


    @Test
    public void withdraw() {
        assertTrue(savingsAccount.withdraw(100000));
        assertTrue(savingsAccount.withdraw(1000000));
    }

    @Test
    public void isAccepted() {
        assertFalse(savingsAccount.isAccepted(6000000));
        assertTrue(savingsAccount.isAccepted(1000000));
    }
}