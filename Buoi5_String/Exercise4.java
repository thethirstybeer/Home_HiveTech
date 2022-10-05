package Buoi5_String;

import java.util.Arrays;

public class Exercise4 {
    public static void main(String[] args) {
        printArray("aabca1b");
    }

    //4. Write a java program to get a string from a given string where all occurrences of its first char have been changed to '$', except the first char itself
    //Sample String : restart
    //Expected Result : resta$t

    public static void printArray(String str){
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++){
                for(int j = i+1; j < c.length; j++){
                    if(c[i] == c[j]){
                        c[j] = '$';
                        break;
                    }
                }
            }
        for(int i = 0; i < c.length; i++){
            System.out.print(c[i]);
        }
    }
}
