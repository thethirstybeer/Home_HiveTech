package Buoi5_String;

public class Exercise1_3 {
    public static void main(String[] args) {
        System.out.println(findUpper("xYxaA123Vx__"));
    }

    // Từ một chuỗi bất kì đếm các kí tự in hoa
        // Sử dụng ascii

    public static int findUpper(String str){
        int count = 0;
        if(str != null){
            for(int i = 0; i < str.length(); i++){
                int ascii = (int) str.charAt(i);
                if(ascii <= 90 && ascii >= 65){
                    count++;
                }
            }
            return count;
        }
        return -1;
    }
}
