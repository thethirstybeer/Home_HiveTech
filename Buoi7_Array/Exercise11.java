package Buoi7_Array;

public class Exercise11 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr, arr.length);
    }

    //11. Write a Java program to reverse an array of integer values
    //ko dùng hàm có sẵn, phải duyệt từ cuối, thêm vào mảng mới hoặc dùng mảng cũ đảo theo cặp pt đầu cuối theo index chạy sau đó đổi vị trí

    public static void reverse(int[] arr, int n){
        if(arr != null){
            int[] reverseArr = new int[n];
            int j = n;
            for(int i = 0; i < n; i++){
                reverseArr[j-1] = arr[i];
                j--;
            }

            for(int i = 0; i < n; i++){
                System.out.println(reverseArr[i] + " ");
            }
        }


    }
}
