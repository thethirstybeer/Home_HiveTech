package Buoi2.BT7;

public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello");
        System.out.println(stringBuilder);
        stringBuilder.append(" Java");
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.subSequence(0,7));
        System.out.println(stringBuilder.delete(0, 4));
    }
}
