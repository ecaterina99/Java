import java.util.ArrayList;
import java.util.List;

public class Library {
    public static int totalBooks = 0;

    List <Book> libraryBooks = new ArrayList<Book>();




    public static int totalBooks(){
         return totalBooks;
     }

     public void addBook(Book book){
       this.libraryBooks.add(book);
       totalBooks++;
     }


}
