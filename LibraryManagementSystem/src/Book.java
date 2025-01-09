
public class Book implements Borrowable {
    public String title;
    public String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean borrow() {
        if (this.isAvailable) {
            isAvailable = false;
            return true;
        }
        else {
            return false;
        }
    }
    public void returnBook() {
        isAvailable = true;
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Book title: ").append(this.title);
        output.append("\nBook author: ").append(this.author);
        output.append("\nAvailability: ").append(this.isAvailable);
        return output.toString();
    }
}
