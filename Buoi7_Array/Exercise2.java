package Buoi7_Array;

public class Exercise2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        sumArray(arr);
    }

    // 2. Write a Java program to sum values of an array
    public static void sumArray(int[] arr){
        if(arr != null){
            int total = 0;
            for (int i = 0; i < arr.length; i++) {
                total += arr[i];
            }
            System.out.println(String.format("Sum of array= %d", total));
        }
    }
}
