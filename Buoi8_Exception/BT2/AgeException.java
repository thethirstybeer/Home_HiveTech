package Buoi8_Exception.BT2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Scanner;

public class AgeException extends RuntimeException {
    public AgeException(String str){
        super(str);
    }

    public static LocalDate excetionDay(String year, String month, String monthDay){
        int d = 0;
        int m = 0;
        int y = 0;
        try{
            d = Integer.parseInt(monthDay);
            m = Integer.parseInt(month);
            y = Integer.parseInt(year);
            if(d < 1 || d > 31 || m < 1 || m > 12 || y < 1990 || y > 2022){
                throw new IllegalArgumentException("Dau vao khong dung voi yeu cau de bai");
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Dau vao khong duoc la Chu");
        }

        return LocalDate.of(y, m, d);
    }

    public static LocalDate createDay(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tinh tuoi toi ngay nhap tu ban phim");
        System.out.print("Nhap ngay: ");
        String monthDay = scanner.nextLine();
        System.out.print("Nhap thang: ");
        String month = scanner.nextLine();
        System.out.print("Nhap nam: ");
        String year = scanner.nextLine();
        return excetionDay(year, month, monthDay);
    }

    public static void main(String[] args) {
//        LocalDate birthDay = excetionDay("2005", "10", "20");
//        LocalDate day = createDay();
//
//        Period p = Period.between(birthDay, day);
//        if(p.getYears() < 0 || p.getMonths() < 0 || p.getDays() < 0){
//            throw new AgeException("KHONG HOP LE!");
//        }
//        System.out.println(String.format("Tuoi hien tai la: %d years, %d months, %d days", p.getYears(), p.getMonths(), p.getDays()));
        String name = "nguyen  hai\tninh";
        String[] names = name.split("\t");
    }
}
