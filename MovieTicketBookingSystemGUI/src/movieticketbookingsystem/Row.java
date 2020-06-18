package movieticketbookingsystem;

import java.util.*;

/**
 * This class represents a row in the cinema hall
 */
public class Row {

    private final ArrayList<Seat> seats;
    private final int rowNumber;
    private final int seatsCount;

    public Row(int rowNumber, int seatsCount) {
        this.seats = new ArrayList<>();
        this.rowNumber = rowNumber;
        this.seatsCount = seatsCount;
        createSeats();
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public final void createSeats() {
        for (int i = 1; i <= seatsCount; i++) {
            seats.add(new Seat(i, rowNumber, false));
        }
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
    
    public Seat getSeat(int seatNumber) {
        return seats.get(seatNumber - 1);
    }

    @Override
    public String toString() {
        String sb = String.format("R%-2d | ", rowNumber);
        for (Seat seat : seats) {
            sb = sb.concat(String.format("%s  ", seat));
        }
        return sb;
    }
    

}
