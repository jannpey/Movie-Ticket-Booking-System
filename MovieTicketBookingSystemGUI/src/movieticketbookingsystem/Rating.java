package movieticketbookingsystem;

/**
 * All the rating types are here
 */
public enum Rating {

    GENERAL(0), ACTION(0), PARENTALGUIDANCE(12), MATURE(16);
    
    private int minAge;

    private Rating(int ratingAge) {
        this.minAge = ratingAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int ratingAge) {
        this.minAge = ratingAge;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
