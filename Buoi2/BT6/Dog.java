package Buoi2.BT6;

public class Dog extends Animal {
   void eat(){
        System.out.println("Eating Rice");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        animal.eat();
        dog.eat();
    }
}
