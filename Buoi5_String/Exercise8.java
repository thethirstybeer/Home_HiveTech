package Buoi5_String;

public class Exercise8 {
    public static void main(String[] args) {
        String[] array = {"BuonCuaNinh", "ab", "abc", "bcaas"};
        System.out.println(longestAndLengthArray(array));
    }

    //8. Write a java function that takes a list of words and return the longest word and the length of the longest one
    public static String longestAndLengthArray(String[] array){
        if(array != null){
            int index = 0;
            int lengthMax = array[0].length();
            for (int i = 1; i < array.length; i++) {
                if(array[i].length() > lengthMax){
                    index = i;
                    lengthMax = array[i].length();
                }
            }
            return String.format("Longest Word: %s\nLength of the longest word: %d", array[index], lengthMax );
        }
        return null;
    }
}
