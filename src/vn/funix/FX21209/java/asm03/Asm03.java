package vn.funix.FX21209.java.asm03;


import vn.funix.FX21209.java.asm03.models.*;

import java.util.Scanner;

public class Asm03 {

    private static final DigitalBank activebank = new DigitalBank();
    private static final DigitalCustomer dicus = new DigitalCustomer();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CUSTOMER_ID = "046200004458";
    private static final String CUSTOMER_NAME = "Danh";

    // add customer
    public static void addCustomer() {
        dicus.setName(CUSTOMER_NAME);
        dicus.setCustomerId(CUSTOMER_ID);
        activebank.addCustomer(dicus);
    }

    // display menu Customer
    private static void getMenuCustomer2 (String AUTHOR, String VERSION) {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | " + AUTHOR + "@v" + VERSION + "                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println(" 1. Thong tin khach hang");
        System.out.println(" 2. Them tai khoan ATM");
        System.out.println(" 3. Them tai khoan tin dung");
        System.out.println(" 4. Rut tien");
        System.out.println(" 5. Lich su giao dich");
        System.out.println(" 0. Thoat");
        System.out.println("+----------+-------------------------+----------+");
    }
    public static void main(String[] args) {
        final String AUTHOR = "FX21209";
        final String VERSION = "3.0.0";
        getMenuCustomer2(AUTHOR, VERSION);
        addCustomer();
        while (true) {
            try {
                System.out.print("Chuc nang: ");
                int n = scanner.nextInt();
                switch (n) {
                    // display Information customer
                    case 1:
                        activebank.ListdisplayInformations();
                        break;
                    // add Loangs Account
                    case 2:
                            System.out.println("Nhap ma so tai khoan gom 6 chu so:");
                            String accountNumberLoan = scanner.next();
                            System.out.println("Nhap so du:");
                            double balanceLoan = scanner.nextDouble();
                            if(activebank.addAccount(CUSTOMER_ID, new LoansAccount(accountNumberLoan, balanceLoan))) {
                                System.out.println("Them tai khoan thanh cong");
                            } else {
                                System.out.println("Them tai khoan that bai");
                            }

                        break;

                    // add Savings Account
                    case 3:

                            System.out.println("Nhap ma so tai khoan gom 6 chu so:");
                            String accountNumberSaving = scanner.next();
                            System.out.println("Nhap so du:");
                            double balanceSaving = scanner.nextDouble();
                            if (activebank.addAccount(CUSTOMER_ID, new SavingsAccount(accountNumberSaving, balanceSaving))) {
                                System.out.println("Them tai khoan thanh cong");
                            } else {
                                System.out.println("Them tai khoan that bai");
                            }

                        break;

                    // withdraw money
                    case 4:
                        System.out.println("Nhap so tai khoan: ");
                        String accountNumber = scanner.next();
                        System.out.println("Nhap so tien can rut: ");
                        double amount = scanner.nextDouble();
                        if (activebank.withdraw(CUSTOMER_ID, accountNumber, amount)) {
                            System.out.println("Rut tien thanh cong");
                        } else {
                            System.out.println("Rut tien khong thanh cong");
                        }
                        break;

                    // Transaction history
                    case 5:
                        activebank.ListdisplayInformations();
                        Customer cus = activebank.searchCustomerByCCCD(CUSTOMER_ID);
                        if (cus != null) {
                            cus.listDisplayTransaction();
                        }
                        break;
                    // exit
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("that bai!");

                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("that bai!");
            }
        }
    }

}
