
public class Librarian extends User {
    public Librarian(String name, int Id) {
        super(name, Id);
    }

    @Override
    public boolean borrowBook(Book book) {
        if (book.borrow()) {
            borrowedBooks.add(book);
            return true;
        }
        System.out.println("This book is already borrowed");
        return false;
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(book.title + " - this book has been returned");
        book.returnBorrowed();
    }

    @Override
    public String getInfo() {
        return "The list of the books borrowed by librarian " + this.getName() + ": " + super.getInfo();
    }
}
