package Buoi5_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1_92 {

    public static void main(String[] args) {
        String str = "456jshd123";
        findNumberToArray(str);
    }

    // 1.92 tách tất cả kí tự số trong chuỗi về mảng số nguyên
    // vd: jshd123
    // [1,2,3]

    public static void findNumberToArray(String str){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            arrayList.add(str.charAt(matcher.start())-'0');
//            arrayList.add(str.charAt(matcher.start())-48);
        }
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
