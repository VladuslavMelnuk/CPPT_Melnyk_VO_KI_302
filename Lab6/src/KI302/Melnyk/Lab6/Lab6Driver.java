package KI302.Melnyk.Lab6;

/**
 * A driver class to test the generic Dictionary.
 * It demonstrates the dictionary's ability to work with different data types (Book and Movie).
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 */
public class Lab6Driver {
    /**
     * The main method is the entry point of the program.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        Dictionary<Integer, Book> library = new Dictionary<>();

        System.out.println("--- Populating Library with Books ---");
        library.add(101, new Book("The Lord of the Rings", 1216));
        library.add(102, new Book("Dune", 412));
        library.add(103, new Book("A Game of Thrones", 694));

        library.display();

        Book largestBook = library.findMax();
        System.out.println("The largest book in the library is: " + largestBook);


        System.out.println("\n=======================================\n");


        Dictionary<String, Movie> filmCollection = new Dictionary<>();

        System.out.println("--- Populating Film Collection with Movies ---");
        filmCollection.add("Warner Bros.", new Movie("Inception", 148));
        filmCollection.add("Paramount", new Movie("Interstellar", 169));
        filmCollection.add("20th Century Fox", new Movie("Avatar", 162));

        filmCollection.display();

        Movie longestMovie = filmCollection.findMax();
        System.out.println("The longest movie in the collection is: " + longestMovie);
    }
}
//javac -d Lab6/bin -sourcepath Lab6/src Lab6/src/KI302/Melnyk/Lab6/*.java
//java -cp Lab6/bin KI302.Melnyk.Lab6.Lab6Driver
//javadoc -d Lab6/doc -sourcepath Lab6/src KI302.Melnyk.Lab6