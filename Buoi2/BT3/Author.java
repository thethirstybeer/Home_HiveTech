package Buoi2.BT3;

import java.util.List;

public class Author {
    private String name; // No default values for the variables
    private String email;
    private char gender; // char of 'm' or 'f'
    private List<Book> books;
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
//        books = new ArrayList<Book>();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Author[name=%s, email=%s, gender=%s]", name, email, gender);
    }

    public static void main(String[] args) {
        Author author = new Author("Nguyen Hai Ninh", "haininh539@gmail.com", 'm');
        System.out.println(author);
    }
}
