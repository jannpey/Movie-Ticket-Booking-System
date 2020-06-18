package movieticketbookingsystem;

public class Film {

    private String id;
    private String title;
    private Rating rating;
    private Cinema cinema;
    private String coverPhoto; // the name of the cover image

    public Film(String id, String title, Rating rating, Cinema cinema, String coverImage) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.coverPhoto = coverImage;
        // create a new cinema instance for the film
        this.cinema = new Cinema(cinema);
    }

    public Film() {
        this.title = "";
        this.rating = Rating.GENERAL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public String getId() {
        return id;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    @Override
    public String toString() {
        return this.getTitle() + "rating: (" + this.getRating() + ")";
    }

}
