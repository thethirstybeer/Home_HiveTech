package Buoi5_String;
public class Exercise2 {
    public static void main(String[] args) {
        characterFrequently("google.com");
    }

    public static void characterFrequently(String str){
        int[] visited = new int[str.length()];
        int[] freq = new int[str.length()];
        int count;
        for(int i = 0; i < str.length(); i++){
            count = 1;
            for(int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    count++;
                    visited[j] = 1;
                }
            }
            freq[i] = count;
        }

        for(int i = 0; i < str.length(); i++){
            if(visited[i] == 0 && i == str.length() - 1){
                System.out.print(str.charAt(i) + ": " + freq[i]);
            }else if(visited[i] == 0){
                System.out.print(str.charAt(i) + ": " + freq[i] + ", ");
            }
        }
    }



    // 2. Write a java program to count the number of characters (character frequency) in a string
    // Sample String : google.com
    // Expected Result : {'g': 2, 'o': 3, 'l': 1, 'e': 1, '.': 1, 'c': 1, 'm': 1}
}