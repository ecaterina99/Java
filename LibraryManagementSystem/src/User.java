import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;
    private int Id;
    List<Book> borrowedBooks = new ArrayList<>();

    public abstract boolean borrowBook(Book book);

    public User(String name, int Id) {
        this.name = name;
        this.Id = Id;
    }

    public User(String name, int Id, List<Book> borrowedBooks) {
        this.name = name;
        this.Id = Id;
        this.borrowedBooks.addAll(borrowedBooks);
    }

    public String getInfo() {
        StringBuilder output = new StringBuilder();
        for (Book book : this.borrowedBooks) {
            if (book != null) {
                output.append(book.title).append(", ");
            }
        }
        if (!output.toString().isEmpty()) {
            output.replace(output.length() - 2, output.length(), ".");
        } else {
            output.append("No books borrowed.");
        }
        return output.toString();
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return Id;
    }

    public void setID(int Id) {
        this.Id = Id;
    }

}

