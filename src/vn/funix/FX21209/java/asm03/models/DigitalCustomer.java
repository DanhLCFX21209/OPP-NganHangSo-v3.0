package vn.funix.FX21209.java.asm03.models;


public class DigitalCustomer extends Customer{
    public DigitalCustomer() {
    }
    // withdraw
    public boolean withdraw(String accountNumber, double amount) {
        Account account = isAccount(accountNumber);
        if(account != null) {

            if(account instanceof SavingsAccount && ((SavingsAccount) account).withdraw(amount)) {
                // display bill
                ((SavingsAccount) account).log(amount);
                // add Transaction history
                account.addTransaction(-amount);
                return true;
            } else if(account instanceof  LoansAccount && ((LoansAccount) account).withdraw(amount)){
                // display bill
                ((LoansAccount) account).log(amount);
                // add Transaction history
                account.addTransaction(-amount);
                return true;
            }
        }
        return false;
    }

    // display customer information
    @Override
    public void displayInformation() {
        String kt = isPremium() ? "Premium" : "Normal";
        System.out.print(getCustomerId() + " |\t\t");
        System.out.print(getName() + " |\t");
        System.out.print(kt + "| \t");
        System.out.printf("%,d", (long)getBalance());
        System.out.println("đ");
        String accountType;
        for(int i=0; i<getAccounts().size(); i++) {
            if(getAccounts().get(i) instanceof SavingsAccount) {
                accountType = "SavingsAccount";
            } else if(getAccounts().get(i) instanceof LoansAccount){
                accountType = "LoansAccount";
            } else {
                accountType = "khong phari tai khoarn";
            }
            System.out.println((i+1) + "\t\t" + accountType +" "+getAccounts().get(i).toString());
        }
    }


}
