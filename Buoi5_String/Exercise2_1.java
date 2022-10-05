package Buoi5_String;

public class Exercise2_1 {
    public static void main(String[] args) {
        findCharacterAndNumber("sad21!d12");
    }
    // 2.1 đếm 1 chuỗi có bao nhiêu kí tự số & chữ cái
    // vd: sad21
    // kq: chu: 3; so: 2

    public static void findCharacterAndNumber(String str){
        int[] count = new int[2];
        for(int i = 0; i < str.length(); i++){
            if(Character.isAlphabetic(str.charAt(i))){
                count[0]++;
            }else if(Character.isDigit(str.charAt(i))){
                count[1]++;
            }
        }
        System.out.println(String.format("Chu: %s, So: %s", count[0], count[1]));

    }
}
