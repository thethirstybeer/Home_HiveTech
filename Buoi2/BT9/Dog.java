package Buoi2.BT9;

public class Dog extends Mamal implements Nameable{

    String name;

    public Dog(){
        super();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName() {
        this.name = name;
    }
}
