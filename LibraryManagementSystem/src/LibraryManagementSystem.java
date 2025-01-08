import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        int booksCounter = 0;

        Book HarryPotter = new Book("Harry Potter", "Joanne Rowling");
        Book HarryPotter2 = new Book("Harry Potter2", "Joanne Rowling");
        Book HarryPotter3 = new Book("Harry Potter3", "Joanne Rowling");
        Book HarryPotter4 = new Book("Harry Potter4", "Joanne Rowling");
        Book TheLordOfTheRings = new Book("The Lord Of the Rings", "J. R. R. Tolkien");
        Book TheLordOfTheRings2 = new Book("The Lord Of the Rings2", "J. R. R. Tolkien");
        Book TheLordOfTheRings3 = new Book("The Lord Of the Rings3", "J. R. R. Tolkien");
        Book TheLordOfTheRings4 = new Book("The Lord Of the Rings4", "J. R. R. Tolkien");

        Book ChristmasStory = new Book("Christmas Story", "John Smith" ,false);

        Library myLibrary = new Library();

        myLibrary.addBook(HarryPotter);
        myLibrary.addBook(HarryPotter2);
        myLibrary.addBook(HarryPotter3);

        List<Book> books = new ArrayList<Book>();
        books.add(TheLordOfTheRings);

        Magazine BAZAAR = new Magazine();

        Member member1 = new Member("John G", 1845);
        Librarian librarian1 = new Librarian("Anna D", 5212);
        Member member2 = new Member("Victor Green", 5541, books);


        member1.borrowBook(HarryPotter);
        member1.borrowBook(HarryPotter2);
        member1.borrowBook(HarryPotter3);
        member1.borrowBook(HarryPotter4);

        librarian1.borrowBook(HarryPotter);
        librarian1.borrowBook(TheLordOfTheRings2);
        librarian1.borrowBook(TheLordOfTheRings3);
        librarian1.borrowBook(TheLordOfTheRings4);
        librarian1.borrowBook(ChristmasStory);

        System.out.println(booksCounter);
        }

    }

