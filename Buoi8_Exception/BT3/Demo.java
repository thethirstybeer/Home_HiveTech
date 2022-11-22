package Buoi8_Exception.BT3;

import java.util.Scanner;

public class Demo {
    static class SumCalcException extends Exception{
        public SumCalcException(String str){
            super(String.format("[element: %s : Can't parse %s to int]", str, str));
        }
    }

    public static int sum(String[] array) throws SumCalcException{
        int total = 0;
        for(int i = 0; i < array.length; i++){
            try {
                int temp = Integer.parseInt(array[i]);
                total += temp;
            }catch (NumberFormatException e){
                throw new SumCalcException(array[i]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[3];
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = scanner.nextLine();
        }
        try {
            total = sum(arr);
            System.out.println("Total: " + total);
        }catch (SumCalcException e){
            System.out.println(e.getMessage());
        }

    }
}
