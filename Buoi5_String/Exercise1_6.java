package Buoi5_String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1_6 {
    public static void main(String[] args) {
        printSpecialCharacter("Make%Selenium$Easy#");
    }

    //    1.6 in ra các kí tự đặc biệt trong chuỗi
    public static void printSpecialCharacter(String str){
        Pattern pattern = Pattern.compile("[ !\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(str.charAt(matcher.start()));
        }

    }

}
