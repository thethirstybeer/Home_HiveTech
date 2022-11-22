package Buoi7_Array;

public class Exercise6 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(indexElement(arr, 3));
    }

    //6. Write a Java program to find the index of an array element.

    public static int indexElement(int[] arr, int element){
        if(arr != null){
            for(int i = 0; i < arr.length; i++){
                if(element == arr[i]){
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }
}
