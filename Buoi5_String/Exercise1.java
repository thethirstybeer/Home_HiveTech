package Buoi5_String;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(findChar("asdasdccsc", 'c'));
    }

    public static String findChar(String str, char c){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(c == str.charAt(i)){
                count++;
            }
        }
        return c + ": " +String.valueOf(count);
    }
}
