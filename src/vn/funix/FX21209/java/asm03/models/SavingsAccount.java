package vn.funix.FX21209.java.asm03.models;


public class SavingsAccount extends Account implements ReportService,Withdraw{

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    private final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    private static final Utils utils = new Utils();

    public String geTitle() {
        return "BIEN LAI GIAO DICH LOAN";
    }

    // log
    @Override
    public void log(double amount) {
        System.out.println(utils.getDivider());
        System.out.printf("%30s%n", geTitle());
        System.out.printf("NGAY G/D: %28s%n", utils.getDatetime());
        System.out.printf("ATM ID %30s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", utils.formatBalance(amount));
        System.out.printf("SO DU: %31s%n", utils.formatBalance(getBalance()));
        System.out.printf("PHI + VAT: %27s%n", 0);
        System.out.println(utils.getDivider());
    }

    // withdraw
    @Override
    public boolean withdraw(double amount) {
        double newBalance = getBalance() - amount;
        if(isAccepted(amount)) {
            setBalance(newBalance);
            return true;
        }

        return false;
    }

    // check amount
    @Override
    public boolean isAccepted(double amount) {
        if(amount >=50000 && (getBalance() - amount) >= 50000 && amount % 10000 ==0) {
            if(!isPremium() && amount >=5000000) {
                return false;
            }
            return true;
        }
        return false;
    }
}
