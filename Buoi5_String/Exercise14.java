package Buoi5_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise14 {
    public static void main(String[] args) {
        printString("red, white, black, red, green, black, blue, red");
    }

    public static void printString(String str){
        String[] strs = str.split(", ");
        int[] visited = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            for(int j = i+1; j < strs.length; j++){
                if(strs[i].equals(strs[j])){
                    visited[j] = 1;
                }
            }
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if(visited[i] != 1){
                arrayList.add(strs[i]);
            }
        }

        Collections.sort(arrayList);
        System.out.println(Arrays.toString(arrayList.toArray()));


    }

//    14. Write a java program that accepts a comma separated sequence of words as input and prints the unique words in sorted form (alphanumerically).
//    Sample Words : red, white, black, red, green, black, blue
//    Expected Result : black, blue, green, red, white
//                      removed duplicate words: red - 1
}
