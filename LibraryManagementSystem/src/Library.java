import java.util.ArrayList;
import java.util.List;

public class Library {
    private static int totalBooks = 0;

    List<Book> libraryBooks = new ArrayList<>();

    public static int getTotalBooks() {
        return totalBooks;
    }

    public void addBook(Book book) {
        this.libraryBooks.add(book);
        totalBooks++;
    }

    public Boolean getInfoBooks(Book book) {
        return true;
    }

    public String getInfo() {
        StringBuilder output = new StringBuilder();
        output.append("Total number of books available at library is: ").append(totalBooks);
        output.append("\nThe list of the books: \n");
        for (Book book : this.libraryBooks) {
            output.append(book.title);
            output.append(", ");
        }
        return output.toString();
    }

}
