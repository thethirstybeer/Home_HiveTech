package Buoi2.BT8;

public class NobodySpecial extends Human implements Plumber, Electrician{

    public NobodySpecial(String name){
        super(name);
    }

    @Override
    public String changeBulb() {
        return null;
    }

    @Override
    public String unplugDrain() {
        return null;
    }

    public String toString(){
        return null;
    }
}
