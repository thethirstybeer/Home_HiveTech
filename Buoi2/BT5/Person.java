package Buoi2.BT5;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Person[name=%s, address=%s]", name, address);
    }

    public static void main(String[] args) {
        Person person = new Person("Nguyen Van A", "Bac Ninh");
        System.out.println(person);
    }
}

