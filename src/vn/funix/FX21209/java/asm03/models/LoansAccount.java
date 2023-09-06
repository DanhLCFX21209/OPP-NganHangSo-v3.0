package vn.funix.FX21209.java.asm03.models;


public class LoansAccount extends Account implements ReportService,Withdraw{

    public LoansAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    private final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    private final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private final double LOAN_ACCOUNT_MAX_BALANCE = 1000000;

    private static final Utils utils = new Utils();

    public String geTitle() {
        return "BIEN LAI GIAO DICH SAVINGS";
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
        System.out.printf("PHI + VAT: %27s%n", utils.formatBalance(getTransactionFee() * amount));
        System.out.println(utils.getDivider());
    }

    // withdraw
    @Override
    public boolean withdraw(double amount) {
        double newBalance = getBalance() - amount - getTransactionFee()*amount;
        if(isAccepted(amount)) {
            setBalance(newBalance);
            return true;
        }
        return false;
    }

    // check amount
    @Override
    public boolean isAccepted(double amount) {
        if(amount <= 100000000 && (getBalance() - amount - getTransactionFee()*amount) >= 50000) {
            return true;
        }
        return false;
    }


}
