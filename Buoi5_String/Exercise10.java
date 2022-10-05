package Buoi5_String;

public class Exercise10 {
    public static void main(String[] args) {
        String str = "alohahoho";
        System.out.println(newString(str));

    }

    //10. Write a java program to change a given string to a new string where the first and last chars have been exchanged.
    //Sample String : alohahoho
    //Expected Result : olohahoha

    public static String newString(String str){
        if(str != null && str.length() > 0){
            int length = str.length();
            return String.format("%s%s%s", str.substring(length-1, length), str.substring(1, length-1), str.substring(0, 1));
        }
        return null;
    }
}
