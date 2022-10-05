package Buoi5_String;

public class Exercise1_7 {
    public static void main(String[] args) {
        String str = "HaiNinh";
        System.out.println(strTrim(str));
    }

    // 1.7 cắt khoảng trắng đầu trong chuỗi
    public static String strTrim(String str){
        if(str != null && str.length() != 0){
            if(str.charAt(0) == ' '){
                return str.substring(1);
            }
            return str;
        }
        return null;
    }
}
