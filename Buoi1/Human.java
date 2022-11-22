package Buoi1;

public class Human {
    private String name;
    private String address;
    private int age;
    private int phoneNumber;
    private double fee;
    private boolean email;
    private char sex;

    public Human(){
        System.out.println(name);
        System.out.println(address);
        System.out.println(age);
        System.out.println(phoneNumber);
        System.out.println(fee);
        System.out.println(email);
        System.out.println(sex);
    }

    public static void walk(){
        System.out.println("I'm walking");
    }

    public static void eat(){
        System.out.println("I'm eating");
    }


    public static void main(String[] args) {
        Human human = new Human();
        human.walk();
        human.eat();
    }

}
