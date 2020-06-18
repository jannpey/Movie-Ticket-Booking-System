package movieticketbookingsystem;

import movieticketbookingsystem.gui.MainMenu;

/**
 * This class represents a customer and this holds the customer details.
 */
public class Customer {

    private String customerId;
    private String name;
    private int age;
    private boolean isStudent;
    private Booking booking;

    public Customer(String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        int nextId = MainMenu.getInstance().getCustomers().size() + 1;
        this.customerId = String.format("C%03d", nextId);
        this.isStudent = isStudent;
    }
    
    public Customer(String id, String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.customerId = id;
        this.isStudent = isStudent;
    }

    public Customer() {
        this.name = "";
        this.age = 0;
        this.isStudent = false;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public boolean IsStudent() {
        return isStudent;
    }

    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public boolean hasBooking() {
        return booking != null;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public String toString() {
        return "CUSTOMER ID: " + customerId + ""
                + "\nNAME: " + getName()
                + "\nAGE: " + getAge() 
                + "\nSTUDENT: " + (isStudent ? "Yes" : "No");

    }

}
