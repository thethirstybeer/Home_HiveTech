package Buoi2.BT4;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private int discount;
    private List<Invoice> invoiceList;

    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        // Note
        return String.format("%s(%o)(%o%s)", name, id, discount, "%");
    }

    public static void main(String[] args) {
        Customer customer = new Customer(153165, "H.Ninh", 10);
        System.out.println(customer);
    }
}
