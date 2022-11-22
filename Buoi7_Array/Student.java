package Buoi7_Array;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private String major;

    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public static void main(String[] args) {
        Student[] students = {new Student(1, "Perter", "IT"), new Student(2, "Adam", "IT"), new Student(3, "Lisa", "IT"), new Student(4, "Var", "IT"), new Student(5, "Mike", "IT"), new Student(6, "Bob", "IT")};
        sort(students);
        print(students);
    }

    public static void swap(Student[] students, int i, int j){
        if(students != null){
            Student temp = students[j];
            students[j] = students[i];
            students[i] = temp;
        }
    }

    public static void sort(Student[] students){
        if(students != null){
            for(int i = 0; i < students.length; i++){
                for(int j = i+1; j < students.length; j++){
                    if(students[i].name.compareTo(students[j].name) > 1){
                        swap(students, i, j);
                    }
                }
            }
        }
    }

    public static void print(Student[] students){
        if(students != null){
            for(int i = 0; i < students.length; i++){
                System.out.print(students[i].name + " ");
            }
        }
    }
}
