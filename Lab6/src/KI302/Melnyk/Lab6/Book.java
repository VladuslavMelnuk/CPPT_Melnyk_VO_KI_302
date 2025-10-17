package KI302.Melnyk.Lab6;

/**
 * A simple Book class that implements the Comparable interface
 * to allow comparison based on page count.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 */
public class Book implements Comparable<Book> {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "Book: '" + title + "' (" + pageCount + " pages)";
    }

    /**
     * Compares this book with another book based on page count.
     * @param other The other book to compare to.
     * @return a negative integer, zero, or a positive integer as this book
     * is less than, equal to, or greater than the specified book.
     */
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pageCount, other.pageCount);
    }
}