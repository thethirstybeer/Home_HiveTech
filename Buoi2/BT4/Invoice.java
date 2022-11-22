package Buoi2.BT4;

import java.text.DecimalFormat;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        if(customer != null){
            this.id = id;
            this.customer = customer;
            this.amount = amount;
        }
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerID(){
        if(customer != null){
            return  customer.getId();
        }
        return -1;
    }

    public String getCustomerName(){
        if(customer != null){
            return  customer.getName();
        }
        return null;
    }

    public int getCustomerDiscount(){
        if(customer != null){
            return  customer.getDiscount();
        }
        return 0;
    }

    public double getAmountAfterDiscount(){

        return amount * (100-customer.getDiscount())/100;
    }

    @Override
    public String toString() {
        if(customer != null){
            return String.format("Invoice[id=%d,%s, amount = %s", id, customer.toString(), amount);
        }
        return null;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        Customer customer = new Customer(153165, "Nguyen Hai Ninh", 8);
        System.out.println("Id is: " + customer.getId());
        System.out.println("Name is: " + customer.getName());
        System.out.println("Discount is: " + customer.getDiscount());
        Invoice invoice = new Invoice(101, customer, 999.9);
        System.out.println("Id is: " + invoice.getId());
        System.out.println("Customer's is: " + invoice.getCustomer());
        System.out.println("Amount is: " + invoice.getAmount());
        System.out.println("Customer's id is: " + invoice.getCustomerID());
        System.out.println("Customer's name is: " + invoice.getCustomerName());
        System.out.println("Customer's discount: " + invoice.getCustomerDiscount());
        System.out.println("Amount after discount is: " + df.format(invoice.getAmountAfterDiscount()));

    }
}
