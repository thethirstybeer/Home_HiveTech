package Buoi2.BT5;

public class Staff extends Person{
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public double getPay() {
        return pay;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return String.format("Staff[%s, school=%s, pay=%.2f]", super.toString(), school, pay);
    }

    public static void main(String[] args) {
        Staff staff = new Staff("Nguyen Van B", "Bac Ninh", "Massachusetts Institute of Technology", 500000000);
        System.out.println(staff);
    }
}
