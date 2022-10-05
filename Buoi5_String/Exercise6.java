package Buoi5_String;

public class Exercise6 {
    public static void main(String[] args) {
        System.out.println(strAddIng("abc"));
        System.out.println(strAddIng("string"));
        System.out.println(strAddIng("Hello"));

    }

    // 6. Write a java program to add 'ing' at the end of a given string (length should be at least 3). If the given string already ends with 'ing' then add 'ly' instead. If the string length of the given string is less than 3, leave it unchanged.
    public static String strAddIng(String str){
        if(str != null && str.length() > 0){
            if(str.length() < 3){
                return str;
            }else {
                if(str.substring(str.length()-3, str.length()).equals("ing")){
                    return str.concat("ly");
                }
                return str.concat("ing");
            }
        }
        return null;
    }
}
