package Buoi5_String;

import java.util.Locale;

public class Exercise1_2 {
    public static void main(String[] args) {
//        System.out.println(upper("abc"));
        System.out.println(upper2("xYz"));
    }
    // Từ một chuỗi bất kì dùng hàm để viết hoa.
        // Có nhiều cách: bảng mã ASCII, sử dụng hàm trong String

    public static String upper(String str){
        if(str!=null){
            return str.toUpperCase(Locale.ROOT);
        }
        return null;

    }

    public static String upper2(String str){
        if(str != null){
            String strUpper = "";
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                int ascii = (int)c;
                if(ascii <= 122 && ascii >= 97){
                    strUpper += String.valueOf((char)(ascii - 32));
                }else {
                    strUpper += str.charAt(i);
                }

            }
            return strUpper;
        }
        return null;
    }
}
