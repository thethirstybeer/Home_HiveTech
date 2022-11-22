package Buoi2.BT5;

public class Student extends Person{
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public int getYear() {
        return year;
    }

    public double getFee() {
        return fee;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return String.format("Student[%s, program=%s, year=%d, fee=%.2f]", super.toString(), program, year, fee);
    }

    public static void main(String[] args) {
        Student student = new Student("Nguyen Van A", "Bac Ninh", "University", 3, 8000000);
        System.out.println(student);
    }
}
