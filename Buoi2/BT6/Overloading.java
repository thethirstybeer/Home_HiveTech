package Buoi2.BT6;

public class Overloading {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
    }

    public static int add(int i, int j){
        return  i + j;
    }

    public static int add(int i, int j, int k){
        return i + j + k;
    }
}
