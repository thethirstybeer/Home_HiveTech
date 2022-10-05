package Buoi5_String;

import java.util.ArrayList;

public class Exercise15 {
    public static void main(String[] args) {
        System.out.println(addTags("span","i", "Java"));
    }

    public static String addTags(String ... tags){
        String str = "";
        for(int i = tags.length-1; i >= 0; i--){
            if(i == tags.length - 1){
                str += tags[i];
            }else {
                str = String.format("<%s>%s<%s>", tags[i], str, tags[i]);
            }
        }
        return str;
    }
}
