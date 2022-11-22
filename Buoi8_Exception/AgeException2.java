package Buoi8_Exception;

import java.time.LocalDate;

public class AgeException2 {
    public static void main(String[] args) {
        System.out.println(excetionDay("2022", "11", "13"));
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
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return LocalDate.of(y, m, d);
    }
}
