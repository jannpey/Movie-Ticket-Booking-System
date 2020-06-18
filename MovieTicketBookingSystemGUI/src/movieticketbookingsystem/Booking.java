package movieticketbookingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This class represents a booking of any ticket
 */
public class Booking {

    private final Customer customer;
    private final Film film;
    private int rowNumber;
    private int seatNumber;
    private String status;

    public Booking(Customer customer, Film film) {
        this.customer = customer;
        this.film = film;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Film getFilm() {
        return film;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double cost() {

        boolean isStudent = this.customer.IsStudent();

        if (customer.getAge() >= 18) {
            return 15;
        }
        if ((customer.getAge() >= 8) && (customer.getAge() <= 20) && isStudent) {
            return 15 * 0.8;
        }
        if ((customer.getAge() > 25) && isStudent) {
            return 15 * 0.93;
        }
        if ((customer.getAge() > 70) && isStudent) {
            return 15 * 0.95;
        } else if (customer.getAge() < 18) {
            return 10;
        }

        return 0;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void reserveSeat(int selectedRow, int selectedSeat) {
        film.getCinema().reserveSeat(selectedRow, selectedSeat);
        this.rowNumber = selectedRow;
        this.seatNumber = selectedSeat;
        this.status = "Active";
    }

    public void reserveSeat(Seat seat) {
        film.getCinema().reserveSeat(seat);
        this.rowNumber = seat.getRowNumber();
        this.seatNumber = seat.getSeatNumber();
        this.status = "Active";
    }

    public void cancel() {
        film.getCinema().unreserveSeat(rowNumber, seatNumber);
        this.rowNumber = 0;
        this.seatNumber = 0;
        this.status = "Canceled";
    }

    public void printTicket() {
        PrintWriter writer = null;
        try {
            // create a file name for the booking ticket
            String fileName = customer.getCustomerId() + "_ticket.txt";
            File fout = new File(fileName);
            writer = new PrintWriter(fout);
            writer.write(toString());
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error when printing ticket: " + ex.getMessage());
        } finally {
            writer.close();
        }
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        String seat = "Not Reserved";
        if(status.equals("Active")) {
            seat = String.format("R%d, S%d\n", rowNumber, seatNumber);
        }
        return "FILM TICKET for: " + this.film.getTitle() + " Rating: (" + this.film.getRating() + ")"
                + "\n" + this.getCustomer() + "\n"
                + "SEAT: " + seat
                + "TOTAL COST: " + this.cost() + "\n"
                + "STATUS: " + status;
    }

}
