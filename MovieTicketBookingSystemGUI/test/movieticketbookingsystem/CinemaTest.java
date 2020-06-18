/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticketbookingsystem;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class CinemaTest {

    /**
     * Test of createRows method, of class Cinema.
     */
    @Test
    public void testCreateRows() {
        System.out.println("createRows");
        Cinema instance = new Cinema(1, "des1", 2, 4);
        ArrayList<Row> rows = instance.getRows();
        assertEquals(2, rows.size());
        assertEquals(4, rows.get(0).getSeats().size());
    }

    /**
     * Test of getCinemaNumber method, of class Cinema.
     */
    @Test
    public void testGetCinemaNumber() {
        System.out.println("getCinemaNumber");
        Cinema instance = new Cinema(1, "des1", 2, 4);
        int expResult = 1;
        int result = instance.getCinemaNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Cinema.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Cinema instance = new Cinema(1, "des1", 2, 4);
        String expResult = "des1";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRowCount method, of class Cinema.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        Cinema instance = new Cinema(1, "des1", 2, 4);
        int expResult = 2;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRowSeatsCount method, of class Cinema.
     */
    @Test
    public void testGetRowSeatsCount() {
        System.out.println("getRowSeatsCount");
        Cinema instance = new Cinema(1, "des1", 2, 4);
        int expResult = 4;
        int result = instance.getRowSeatsCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFreeSeats method, of class Cinema.
     */
    @Test
    public void testGetFreeSeats() {
        System.out.println("getFreeSeats");
        Cinema instance = new Cinema(1, "des1", 2, 4);
        int expResult = 8;
        int result = instance.getFreeSeats();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method, of class Cinema.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        Cinema instance = new Cinema(1, "des1", 2, 4);
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeat method, of class Cinema.
     */
    @Test
    public void testGetSeat() {
        System.out.println("getSeat");
        int rowNumber = 1;
        int seatNumber = 1;
        Cinema instance = new Cinema(1, "des1", 2, 4);
        Seat expResult = new Seat(seatNumber, rowNumber, false);
        Seat result = instance.getSeat(rowNumber, seatNumber);
        assertEquals(expResult.getSeatNumber(), result.getSeatNumber());
        assertEquals(expResult.getRowNumber(), result.getRowNumber());
    }

    /**
     * Test of reserveSeat method, of class Cinema.
     */
    @Test
    public void testReserveSeat_int_int() {
        System.out.println("reserveSeat");
        int rowNumber = 1;
        int seatNumber = 1;
        Cinema instance = new Cinema(1, "des1", 2, 4);
        instance.reserveSeat(rowNumber, seatNumber);
        assertEquals(instance.getSeat(rowNumber, seatNumber).isIsReserved(), true);
    }

    /**
     * Test of reserveSeat method, of class Cinema.
     */
    @Test
    public void testReserveSeat_Seat() {
        System.out.println("reserveSeat");
        Seat seat = new Seat(1, 2, false);
        Cinema instance = new Cinema(1, "des1", 2, 4);
        instance.reserveSeat(seat);
        assertEquals(instance.getSeat(2, 1).isIsReserved(), true);
    }

    /**
     * Test of unreserveSeat method, of class Cinema.
     */
    @Test
    public void testUnreserveSeat() {
        System.out.println("unreserveSeat");
        int rowNumber = 2;
        int seatNumber = 2;
        Cinema instance = new Cinema(1, "des1", 2, 4);
        instance.reserveSeat(rowNumber, seatNumber);
        assertEquals(instance.getSeat(rowNumber, seatNumber).isIsReserved(), true);
        instance.unreserveSeat(rowNumber, seatNumber);
        assertEquals(instance.getSeat(rowNumber, seatNumber).isIsReserved(), false);
    }


}
