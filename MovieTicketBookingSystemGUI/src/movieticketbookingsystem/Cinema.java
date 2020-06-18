package movieticketbookingsystem;

import java.util.*;

/**
 * This class represents the cinema hall
 */
public class Cinema {

    private final int cinemaNumber;
    private final String description;
    private final int rowCount;
    private final int rowSeatsCount;
    private int freeSeats;
    private final ArrayList<Row> rows;

    public Cinema() {
        this.cinemaNumber = 0;
        this.description = null;
        this.rowCount = 0;
        this.rowSeatsCount = 0;
        this.rows = new ArrayList<>();
    }

    public Cinema(int cinemaNumber, String description, int rowCount, int rowSeatsCount) {
        this.cinemaNumber = cinemaNumber;
        this.description = description;
        this.rowCount = rowCount;
        this.rowSeatsCount = rowSeatsCount;
        this.freeSeats = rowCount * rowSeatsCount;
        this.rows = new ArrayList<>();
        createRows();
    }

    public Cinema(Cinema c) {
        this.cinemaNumber = c.cinemaNumber;
        this.description = c.description;
        this.rowCount = c.rowCount;
        this.rowSeatsCount = c.rowSeatsCount;
        this.freeSeats = c.freeSeats;
        this.rows = new ArrayList<>();
        // load the seats
        createRows();
    }

    public final void createRows() {
        for (int i = 1; i <= rowCount; i++) {
            rows.add(new Row(i, rowSeatsCount));
        }
    }

    public int getCinemaNumber() {
        return cinemaNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getRowSeatsCount() {
        return rowSeatsCount;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public boolean isFull() {
        return freeSeats == 0;
    }

    public Seat getSeat(int rowNumber, int seatNumber) {
        return rows.get(rowNumber - 1).getSeat(seatNumber);
    }

    public void reserveSeat(int rowNumber, int seatNumber) {
        getSeat(rowNumber, seatNumber).reserve();
        freeSeats--;
    }
    
    public void reserveSeat(Seat seat) {
        reserveSeat(seat.getRowNumber(), seat.getSeatNumber());
    }
    
    public void unreserveSeat(int rowNumber, int seatNumber) {
        getSeat(rowNumber, seatNumber).closeReserve();
        freeSeats++;
    }

    @Override
    public String toString() {
        String sb = String.format("%-3s | ", "");
        for (int i = 1; i <= rowSeatsCount; i++) {
            sb = sb.concat(String.format("%s  ", i));
        }
        sb = sb.concat("\n");
        for (int i = 1; i <= rowSeatsCount; i++) {
            sb = sb.concat("----");
        }
        sb = sb.concat("\n");

        for (Row row : rows) {
            sb = sb.concat(row.toString()).concat("\n");
        }
        
        sb = sb.concat("\nFree Seats = " + freeSeats + "\n");
        return sb;
    }

}
