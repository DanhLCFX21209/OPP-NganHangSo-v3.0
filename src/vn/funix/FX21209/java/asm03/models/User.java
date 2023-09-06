package vn.funix.FX21209.java.asm03.models;

public class User {
    private String name;
    private String customerId;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        String[] provinceCodes = {"001","002","003","004","008","010","011","012","014","015","017","019","020","022"
                ,"024","025","026","027","030","031","033","034","035","036","037","038","040","042","044","045","046"
                ,"048","049","051","052","054","056","058","060","062","064","066","067","068","070","072","074","075"
                ,"077","079","080","082","083","084","086","087","089","091","092","093","094","095","096"};
        if (checkCccd(customerId, provinceCodes)) {
            this.customerId = customerId;
        }
    }
    // check if CCCD is valid
    public static boolean checkCccd (String customerId, String[] provinceCodes) {
        String cccd1 = customerId.substring(0, 3);
        if(customerId.length() != 12 || !customerId.matches("[0-9]+")) {
            return false;
        }
        for(int i=0; i<provinceCodes.length; i++) {
            if(provinceCodes[i].equals(cccd1)) {
                return true;
            }
        }
        return false;
    }
}
