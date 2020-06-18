package movieticketbookingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import movieticketbookingsystem.gui.MainMenu;

/**
 * This class handles the database operation for the system
 */
public class DatabaseConnection {

    private Connection connection;
    private Statement statement;

    private final String URL = "jdbc:derby://localhost:1527/MovieTicketDB";
    private final String USER_NAME = "Jann";
    private final String PASSWORD = "123";

    public DatabaseConnection() {

        try {
            this.connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            this.statement = connection.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * This method save the given booking to the database
     *
     * @param booking
     */
    public void insertBooking(Booking booking) {
        try {
            String sql = "INSERT INTO bookings (filmid, customerid, rownumber, seatnumber, cost, status)"
                    + "VALUES ('"
                    + booking.getFilm().getId() + "','"
                    + booking.getCustomer().getCustomerId() + "',"
                    + booking.getRowNumber() + ","
                    + booking.getSeatNumber() + ","
                    + booking.cost() + ",'"
                    + booking.getStatus() + "'"
                    + ")";

            statement.execute(sql);
            System.out.println("Booking was saved into the database");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method save the given customer to the database
     *
     * @param cus
     */
    public void insertCustomer(Customer cus) {
        try {
            String sql = "INSERT INTO customer (id, name, age, " + "isstudent)"
                    + "VALUES ('"
                    + cus.getCustomerId() + "','"
                    + cus.getName() + "',"
                    + cus.getAge() + ","
                    + cus.IsStudent()
                    + ")";

            statement.execute(sql);
            System.out.println("Customer was saved into the database");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Cinema> retriveCinemas() {
        ArrayList<Cinema> cinemas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cinemas";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String des = resultSet.getString(2);
                int rows = resultSet.getInt(3);
                int seats = resultSet.getInt(4);

                Cinema cinema = new Cinema(id, des, rows, seats);

                cinemas.add(cinema);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cinemas;
    }

    public ArrayList<Customer> retriveCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM customer";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                boolean isStudent = resultSet.getBoolean(4);

                Customer cus = new Customer(id, name, age, isStudent);
                customers.add(cus);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return customers;
    }

    public ArrayList<Film> retriveFims(ArrayList<Cinema> cinemas) {
        ArrayList<Film> films = new ArrayList<>();
        try {
            String sql = "SELECT * FROM films";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                Rating rating = Rating.valueOf(resultSet.getString(3).trim());
                int cinemaId = resultSet.getInt(4);
                String coverImage = resultSet.getString(5);

                // create a film from the data
                Film film = new Film(id, title, rating, cinemas.get(cinemaId - 1), coverImage);

                films.add(film);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return films;
    }

    public Booking retriveBookingByCustomerId(String cusId) {

        Booking booking = null;
        try {
            String sql = "SELECT * FROM bookings where customerid = '" + cusId + "'";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String filmId = resultSet.getString(1);
                int rowNumber = resultSet.getInt(3);
                int seatNumber = resultSet.getInt(4);
                String status = resultSet.getString(6);

                Film film = MainMenu.getInstance().getFilmById(filmId);
                Customer customer = MainMenu.getInstance().getCustomerById(cusId);

                // create a film from the data
                booking = new Booking(customer, film);
                if (status.equalsIgnoreCase("Active")) {
                    booking.reserveSeat(rowNumber, seatNumber);
                }
                booking.setStatus(status);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return booking;
    }

    public void cancelBookingByCustomerId(String cusId) {

        try {
            String sql = "update bookings set status = 'Canceled' where customerid = '" + cusId + "'";

            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void close() {
        try {
            // close the connection
            connection.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
