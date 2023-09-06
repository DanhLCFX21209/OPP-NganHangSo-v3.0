package vn.funix.FX21209.java.asm03.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void checkCccd() {
        User user = new User();
        String[] provinceCodes = {"001","002","003","004","008","010","011","012","014","015","017","019","020","022"
                ,"024","025","026","027","030","031","033","034","035","036","037","038","040","042","044","045","046"
                ,"048","049","051","052","054","056","058","060","062","064","066","067","068","070","072","074","075"
                ,"077","079","080","082","083","084","086","087","089","091","092","093","094","095","096"};
        assertTrue(user.checkCccd("046200004458", provinceCodes));
        assertFalse(user.checkCccd("123123456789", provinceCodes));
    }
}