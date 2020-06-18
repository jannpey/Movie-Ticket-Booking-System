package movieticketbookingsystem;

/**
 * This class represents a seat of the cinema hall
 */
public class Seat {

    private final int seatNumber;
    private final int rowNumber;
    private boolean isReserved;

    public Seat(int seatNumber, int rowNumber, boolean isReserved) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.isReserved = isReserved;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public boolean isIsReserved() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void closeReserve() {
        isReserved = false;
    }

    @Override
    public String toString() {
        return String.format("R%d S%d", rowNumber, seatNumber);
    }

}
