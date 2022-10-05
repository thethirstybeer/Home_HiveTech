package Buoi5_String;

public class Exercise1_4 {
    public static void main(String[] args) {
        String str = "123abc567";
        System.out.println(countNumber(str));
    }

//    1.4 đếm các các kí tự số trong chuỗi
    public static int countNumber(String str){
        int count = 0;
        if(str != null){
            for(int i = 0; i < str.length(); i++){
                int ascii = (int) str.charAt(i);
                if(ascii < 58 && ascii > 47){
                    count++;
                }
            }
            return count;
        }
        return -1;
    }
}
