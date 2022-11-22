package Buoi8_Exception.BT5;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate birthDay;

    public Student(int id, String name, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return String.format("Student[id=%d, name=%s, birthDay=%s]", id, name, birthDay);
    }



}
