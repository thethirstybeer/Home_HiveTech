package Buoi8_Exception.BT4;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
       String fullname =  enterName();
       System.out.println(fullname);
    }

    // Là alphabe or khoảng trắng.
    public static String enterName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String fullName = scanner.nextLine();
        char[] arr = fullName.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if(!(temp > 64 && temp < 91) && !(temp > 96 && temp < 123) && temp != 32){
                throw new RuntimeException(arr[i] + " Khong phai alphabe hoặc khoảng trắng");
            }
        }
        return String.valueOf(arr);
    }
}
