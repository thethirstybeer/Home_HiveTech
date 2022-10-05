package Buoi5_String;

public class Exercise1_9 {
    public static void main(String[] args) {
        String str = "abbas";
        System.out.println(subStr(str));
    }

    //1.9 cắt chuỗi từ kí tự 2 đến hết chuỗi
    public static String subStr(String str){
        if(str != null && str.length() > 2){
            return str.substring(2);
        }
        return null;
    }
}
