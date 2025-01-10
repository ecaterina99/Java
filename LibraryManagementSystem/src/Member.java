import java.util.List;

public class Member extends User {
    public Member(String name, int Id) {
        super(name, Id);
    }

    public Member(String name, int Id, List<Book> borrowedBooks) {
        super(name, Id, borrowedBooks);
    }

    @Override
    public boolean borrowBook(Book book) {

        if (borrowedBooks.size() < 3) {
            if (book.borrow()) {
                borrowedBooks.add(book);
                return true;
            }

            System.out.println("This book is already borrowed");
        } else {
            System.out.println("You are not allowed to borrow more books");
        }
        return false;
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(book.title + " - this book has been returned");
        book.returnBorrowed();
    }

    @Override
    public String getInfo() {
        return "The list of the books borrowed by member " + this.getName() + ": " + super.getInfo();

    }
}


