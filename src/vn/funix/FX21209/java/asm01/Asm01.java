package vn.funix.FX21209.java.asm01;

import java.lang.invoke.MethodHandles;
import java.util.Random;
import java.util.Scanner;

public class Asm01 {

    // display menu
    public static void getMenu1 (String AUTHOR, String VERSION) {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | " + AUTHOR + "@v" + VERSION + "                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Nhap CCCD                                  |");
        System.out.println("| 0. Thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
    }
    public static void getMenu2 () {
        System.out.println("Vui long chon che do:");
        System.out.println(" | 1. EASY");
        System.out.println(" | 2. HARD");
    }
    public static void getMenu3 () {
        System.out.println("   | 1. Kiem tra noi sinh");
        System.out.println("   | 2. Kiem tra tuoi, gioi tinh");
        System.out.println("   | 3. Kiem tra so ngau nhien");
        System.out.println("   | 0. Thoat");
    }

    // Random
    // Random 3 numbers
    public static String RandomThreeNumber () {
        Random random = new Random();
        // random 100 to 999
        int number = random.nextInt(900) + 100;
        String numberStr = String.valueOf(number);
        return numberStr;
    }
    // Random 6 characters including numbers and letters
    public static String generateRandomString() {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }


    // check CCCD
    public static boolean checkCccd (String cccd, String[] provinceCodes) {
        String cccd1 = cccd.substring(0, 3);
        if(cccd.length() != 12 || !cccd.matches("[0-9]+")) {
           return false;
       }
        for(int i=0; i<provinceCodes.length; i++) {
            if(provinceCodes[i].equals(cccd1)) {
                return true;
            }
        }

        return false;
    }

//    get information about province
    public static String getProvince(String cccd, String[] provinceCodes, String[] provinceNames) {
        String cccd2 = cccd.substring(0,3);
         for(int i=0; i<provinceCodes.length; i++) {
             if(provinceCodes[i].equals(cccd2)) {
                 return provinceNames[i];
             }
         }
        return null;
    }


    //get gender
    public static String getGender(String cccd) {
        String genderStr = cccd.substring(3,4);
        int gender = Integer.parseInt(genderStr);
        if(gender % 2 == 0) {
            return "Nam";
        } else {
            return "Nu";
        }
    }
    // get year of birth information
    public static int getYear(String cccd) {
        String genderStr = cccd.substring(3,4);
        String yearStr = cccd.substring(4,6);
        int gender = Integer.parseInt(genderStr);
        int year = Integer.parseInt(yearStr);
        switch (gender) {
            case 0:
            case 1:
                year = 1900 + year;
                break;
            case 2:
            case 3:
                year = 2000 + year;
                break;
            case 4:
            case 5:
                year = 2100 + year;
                break;
            case 6:
            case 7:
                year = 2100 + year;
                break;
            case 8:
            case 9:
                year = 2100 + year;
                break;

        }
        return year;
    }


    public static void main(String[] args) {
        final String AUTHOR = "FX21209";
        final String VERSION = "1.0.0";
        String[] provinceCodes = {"001","002","003","004","008","010","011","012","014","015","017","019","020","022"
                ,"024","025","026","027","030","031","033","034","035","036","037","038","040","042","044","045","046"
                ,"048","049","051","052","054","056","058","060","062","064","066","067","068","070","072","074","075"
                ,"077","079","080","082","083","084","086","087","089","091","092","093","094","095","096"};
        String[] provinceNames = {"Ha noi","Ha Giang","Cao Bang","Bac Kan","Tuyen Quang","Lao Cai","Dien Bien","Lai Chau"
                ,"Son La","Yen Bai","Hoa Binh","Thai Nguyen","Lang Son","Quang Ninh","Bac Giang","Phu Tho"
                ,"Vinh Phuc","Bac Ninh","Hai Duong","Hai Phong","Hung Yen","Thai Binh","Ha Nam","Nam Dinh"
                ,"Ninh Binh","Thanh Hoa","Nghe An","Ha Tinh","Quang Binh","Quang Tri","Thua Thien Hue","Da Nang"
                ,"Quang Nam","Quang Ngai","Binh Dinh","Phu Yen","Khanh Hoa","Ninh Thuan","Kom Tum","Gia Lai","Dak Lak"
                ,"Dak Nong","Lam Dong","Binh Phuoc","Tay Ninh","Binh Duong","Dong Nai","Ba Ria-Vung Tau","Ho Chi Minh"
                ,"Long An","Tien Giang","Ben Tre","Tra Vinh","Vinh Long","Dong Thap","An Giang","Kien Giang","Can Tho"
                ,"Hau Giang","Soc Trang","Bac Lieu","Ca Mau"};

        getMenu1(AUTHOR, VERSION);

        // repeat if n != 0.Nhap CCCD  or n != 1.Thoat
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Chuc nang: ");
                int n = scanner.nextInt();
                if (n == 1) {
                    getMenu2();
                    // repeat if n1 != 1.EASY  or n1 != 2.HARD
                    while (true) {
                        try {
                            System.out.print("Chuc nang: ");
                            int n1 = scanner.nextInt();
                            if(n1 == 1 || n1 == 2) {

                                // repeat if the authentication code is not correct
                                while (true) {
                                    try {
                                        System.out.print("Nhap ma xac thuc: ");
                                        String randum = (n1 == 1) ? RandomThreeNumber() : generateRandomString();
                                        System.out.println(randum);
                                        String k = scanner.next();
                                        if (k.equals(randum)) {
                                            System.out.print("Vui long nhap so CCCD:  ");

                                            // repeat if check cccd number is incorrect
                                            while (true) {
                                                try {
                                                    String cccd = scanner.next();
                                                    //  if cccd = "No" -> exit()
                                                    if (cccd.equals("No")) {
                                                        System.exit(0);
                                                    }
                                                    if (checkCccd(cccd, provinceCodes)) {

                                                        // repeat if n != 0.Thoat , n != 1.Noi sinh , n != 2.Gioi tinh , n != 3.So ngau nhien
                                                        while (true) {
                                                            try {
                                                                getMenu3();
                                                                System.out.print("Chuc nang: ");
                                                                int kt = scanner.nextInt();
                                                                switch (kt) {
                                                                    case 1:
                                                                        System.out.println("Noi sinh: " + getProvince(cccd, provinceCodes, provinceNames));
                                                                        break;
                                                                    case 2:
                                                                        System.out.println("Gioi tinh: " + getGender(cccd) + " | " + getYear(cccd));
                                                                        break;
                                                                    case 3:
                                                                        System.out.println("So ngau nhien: " + cccd.substring(6,12));
                                                                        break;
                                                                    case 0:
                                                                        System.exit(0);
                                                                }
                                                            } catch (Exception e4) {
                                                                scanner.nextLine();
                                                                System.out.println("Nhap lai!");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("So CCCD khong hop le.");
                                                        System.out.print("Vui long nhap lai hoac 'No' de thoat: ");
                                                    }
                                                } catch (Exception e3) {
                                                    scanner.nextLine();
                                                    System.out.println("So CCCD khong hop le.");
                                                    System.out.print("Vui long nhap lai hoac 'No' de thoat: ");
                                                }

                                            }

                                        } else {
                                            System.out.println("Ma xac thuc khong dung. Vui long thu lai");
                                        }
                                    } catch (Exception e2) {
                                        scanner.nextLine();
                                        System.out.println("Ma xac thuc khong dung. Vui long thu lai");
                                    }

                                }
                            } else {
                                System.out.println("Chon che do khong dung. Vui long thu lai");
                            }
                        } catch (Exception e1) {
                            scanner.nextLine();
                            System.out.println("Chon che do khong dung. Vui long thu lai");
                        }
                    }


                } else if (n == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Nhap lai!");
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Nhap lai!");
            }

        }


    }



}
