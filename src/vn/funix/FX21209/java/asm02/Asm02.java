package vn.funix.FX21209.java.asm02;

import vn.funix.FX21209.java.asm02.models.Bank;

import java.util.Scanner;

class Asm02 {
    // display menu Customer
    private static void getMenuCustomer (String AUTHOR, String VERSION) {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | " + AUTHOR + "@v" + VERSION + "                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println(" 1. Them khach hang");
        System.out.println(" 2. Them tai khoan cho khach hang");
        System.out.println(" 3. Hien thi danh sach khach hang");
        System.out.println(" 4. Tim theo CCCD");
        System.out.println(" 5. Tim theo ten khach hang");
        System.out.println(" 0. Thoat");
        System.out.println("+----------+-------------------------+----------+");
    }

    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        final String AUTHOR = "FX21209";
        final String VERSION = "2.0.0";
        getMenuCustomer(AUTHOR, VERSION);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Chuc nang: ");
                int n = scanner.nextInt();
                switch (n) {
                // add customer
                case 1:
                    System.out.print("Nhap ten khach hang: ");
                    String name = scanner.next();
                    while (true) {
                        try {
                            System.out.print("Nhap so CCCD: ");
                            String customerId = scanner.next();
                            if(customerId.equals("No")) {
                                break;
                            }

                            if(bank.addCustomer(name, customerId)) {
                                bank.addCustomer(name, customerId);
                                System.out.println("them thanh cong");
                                break;
                            } else {
                                System.out.println("So CCCD khong hop le,");
                                System.out.println("Vui long nhap lai hoac 'No' de thoat");
                            }
                        } catch (Exception e1) {
                            System.out.println("So CCCD khong hop le,");
                            System.out.println("Vui long nhap lai hoac 'No' de thoat");
                        }
                    }
                    break;
                // add account
                case 2:
                    while (true) {
                        try {
                            System.out.println("Nhap CCCD Khach hang:");
                            String customerId = scanner.next();
                            System.out.println("Nhap ma STK gom 6 chu so:");
                            String accountNumber = scanner.next();
                            System.out.println("Nhap so du:");
                            double balance = scanner.nextDouble();
                            bank.addAccount(customerId, accountNumber, balance);
                            if(bank.addAccount(customerId, accountNumber, balance)) {
                                System.out.println("Them tai khoan thanh cong");
                                break;
                            } else {
                                System.out.println("Nhap lai");
                            }
                        } catch (Exception e2) {
                            System.out.println("Nhap lai");
                        }
                    }
                    break;

                // display list customer
                case 3:
                    if(bank.getCustomers().size() != 0) {
                        bank.ListdisplayInformations();
                    } else {
                        System.out.println("Danh sach khach hang rong!");
                    }
                    break;
                // search Customer by CCCD
                case 4:
                    System.out.println("Nhap CCCD khach hang: ");
                    String customerId = scanner.next();
                    if(bank.searchCustomerByCCCD(customerId) != null) {
                        bank.searchCustomerByCCCD(customerId).displayInformation();
                    } else {
                        System.out.println("Khong tim thay CCCD hop le!");
                    }
                    break;
                // search Customer by name
                case 5:
                    System.out.println("Nhap ten khach hang: ");
                    String name2 = scanner.next();
                    bank.searchCustomerByName(name2);
                    break;
                // exit
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long nhap lai!");

            }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Vui long nhap lai!");
            }
        }
    }

}
