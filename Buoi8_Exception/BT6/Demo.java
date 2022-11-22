package Buoi8_Exception.BT6;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        String str = "asdhej3.115huwh8mk9.8jdhf0.8";
        char[] chars = str.toCharArray();
        int[] booleans = new int[chars.length];
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(chars[i])){
                booleans[i] = 1;
            }else if(chars[i] == '.'){
                booleans[i] = 2;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < booleans.length; i++){
            if(booleans[i] == 1 || booleans[i]==2){
                temp += chars[i];
                if(i == (booleans.length-1)){
                    if(temp.length() > 0){
                        arrayList.add(temp);
                    }
                }
            }else if(booleans[i] == 0){
                if(temp.length() > 0){
                    arrayList.add(temp);
                }
                temp = "";
            }
        }
        int totalInteger = totalInteger(arrayList);
        System.out.println(totalInteger);
        double totalDecimal = totalDecimal(arrayList);
        System.out.println(totalDecimal);
        String[] strs = "3.151".split("\\.");
        System.out.println(strs);
    }

    public static double totalDecimal(ArrayList<String> arrayList){
        if(arrayList != null){
            double total = 0;
            for (int i = 0; i <arrayList.size(); i++) {
                String[] strs = arrayList.get(i).split("\\.");
                total += Integer.parseInt(strs[1]);
            }
            return total;
        }
        return -1;
    }

    public static int totalInteger(ArrayList<String> arrayList){
        if(arrayList != null){
            int total = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                total += (int) Double.parseDouble(arrayList.get(i));
            }
            return total;
        }
        return -1;
    }
}
