package Buoi5_String;

public class Exercise1_1 {
    public static void main(String[] args) {
        System.out.println(add2String("abc", "cba"));
    }

    // Cộng hai chuỗi bất kì thành 1 chuỗi. Không cần nhập bàn phím.

        // Có nhiều cách: Sử dụng toán tử "+", sử dụng concat của String, sử dụng append của StringBuilder or StringBuffer.
    public static String add2String(String str1, String str2){
        if(str1 != null){
            return str1 + str2;
        }
        return str1 + str2;
    }

    public static String add2String2(String str1, String str2){
        if(str1 != null){
            return str1.concat(str2);
        }
        return str1.concat(str2);
    }

    public static String add2String3(String str1, String str2){
        StringBuilder stringBuilder = new StringBuilder(str1);
        if(str1 != null){
            return stringBuilder.append(str2).toString();
        }
        return stringBuilder.append(str2).toString();
    }
}
