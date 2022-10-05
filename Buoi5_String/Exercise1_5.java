package Buoi5_String;

public class Exercise1_5 {
    public static void main(String[] args) {
        String str = "abcdef";
        print(str);
    }

    //1.5 in ra các kí tự tại vị trí lẻ trong chuỗi
    public static void print(String str){
        if(str != null){
            for (int i = 1; i < str.length(); i+=2) {
                System.out.print(str.charAt(i) + " ");
            }
        }
    }
}
