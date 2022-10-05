package Buoi5_String;

public class Exercise5 {
    public static void main(String[] args) {
        System.out.println(singleSpecial("abc", "xyz"));
        System.out.println(singleSpecial("asdqa", "545sad"));
    }

    //5. Write a java program to get a single string from two given strings, separated by a space and swap the first two characters of each string.

    public static String singleSpecial(String str1, String str2){
        if(str2 != null && str2.length() > 0){
            return String.format("%s %s",str2.substring(0, 2).concat(str1.substring(2)),str1.substring(0, 2).concat(str2.substring(2)));
        }
        return null;
    }
}
