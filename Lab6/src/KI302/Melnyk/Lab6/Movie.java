package KI302.Melnyk.Lab6;

/**
 * A simple Movie class that implements the Comparable interface
 * to allow comparison based on duration.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 */
public class Movie implements Comparable<Movie> {
    private String title;
    private int durationMinutes;

    public Movie(String title, int durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return "Movie: '" + title + "' (" + durationMinutes + " min)";
    }

    /**
     * Compares this movie with another movie based on duration.
     * @param other The other movie to compare to.
     * @return a negative integer, zero, or a positive integer as this movie
     * is less than, equal to, or greater than the specified movie.
     */
    @Override
    public int compareTo(Movie other) {
        return Integer.compare(this.durationMinutes, other.durationMinutes);
    }
}